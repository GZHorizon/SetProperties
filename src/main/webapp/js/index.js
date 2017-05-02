$(function(){
    $('#submit').on('click',function () {
        var inputUrl = $('#installation-path').val();
        if(inputUrl == ""){
            $('#msg-dialog p').text("请输入BS系统安装的tomcat路径。");
            msgDialog.dialog('open');
            return false;
        }
        $.post('getProperties.do',{ url : $('#installation-path').val() },function(data){
            console.log(data)
            if(data.errorMessage != undefined){
                $('#installation-path').val(function(){
                    return $('#installation-path').val()+data.errorMessage
                })
                $('#jdbc').html("");
                $('#log').html("");
                $('#thirdrecharge').html("");
                return false;
            }
            var jdbcHtml =  ''
            for(var k in data.jdbcvo){
                jdbcHtml = jdbcHtml + '<li class="row"><label class="btn  btn-info col-md-3" disabled>'+k+'</label><input class="form-control col-md-5" id="'+k+'" value="'+data.jdbcvo[k]+'"/></li>';
            }
            $('#jdbc').html(jdbcHtml)


            var logHtml =  ''
            for(var k in data.logvo){
                logHtml = logHtml + '<li class="row"><label class="btn  btn-info col-md-3" disabled>'+k+'</label><input class="form-control col-md-5" id="'+k+'" value="'+data.logvo[k]+'"/></li>';
            }
            $('#log').html(logHtml)

            if(data.thirdrechargevo.md5Key != null && data.thirdrechargevo.md5Key != "null" && data.thirdrechargevo.md5Key != undefined && data.thirdrechargevo.md5Key != ""){
                var thirdrechargeHtml =  ''
                for(var k in data.thirdrechargevo){
                    thirdrechargeHtml = thirdrechargeHtml + '<li class="row"><label class="btn  btn-info col-md-3" disabled>'+k+'</label><input class="form-control col-md-5" id="'+k+'" value="'+data.thirdrechargevo[k]+'"/></li>';
                }
                $('#thirdrecharge').html(thirdrechargeHtml)
            }
        })
    })

    $('#save').on('click',function(){
        $('#msg-dialog p').text("正在修改配置文件，请稍等......");
        $('.ui-dialog-buttonset .button').attr({disabled: "disabled"})
        msgDialog.dialog('open');

        $.post("saveProperties.do",{
            url : $('#installation-path').val(),
            jdbcDriver : $('#jdbc\\.driver').val(),
            jdbcUrl : $('#jdbc\\.url').val(),
            jdbcUser : $('#jdbc\\.user').val(),
            jdbcPassword : $('#jdbc\\.password').val(),

            jdbcInitialSize : $('#jdbc\\.initialSize').val(),
            jdbcMaxActive : $('#jdbc\\.maxActive').val(),
            jdbcMinIdle : $('#jdbc\\.minIdle').val(),
            jdbcMaxIdle : $('#jdbc\\.maxIdle').val(),
            jdbcValidationQuery : $('#jdbc\\.validationQuery').val(),
            jdbcTestOnBorrow : $('#jdbc\\.testOnBorrow').val(),
            jdbcTestOnReturn : $('#jdbc\\.testOnReturn').val(),
            jdbcTestWhileIdle : $('#jdbc\\.testWhileIdle').val(),
            jdbcTimeBetweenEvictionRunsMillis : $('#jdbc\\.timeBetweenEvictionRunsMillis').val(),
            jdbcNumTestsPerEvictionRun : $('#jdbc\\.numTestsPerEvictionRun').val(),
            jdbcRemoveAbandoned : $('#jdbc\\.removeAbandoned').val(),
            jdbcRemoveAbandonedTimeout : $('#jdbc\\.removeAbandonedTimeout').val(),
            jdbcMaxWait : $('#jdbc\\.maxWait').val(),
            jdbcDefaultAutoCommit : $('#jdbc\\.defaultAutoCommit').val(),
            jdbcLogAbandoned : $('#jdbc\\.logAbandoned').val(),
            logDriver : $('#log4j\\.appender\\.DATABASE\\.driver').val(),
            logUrl : $('#log4j\\.appender\\.DATABASE\\.URL').val(),
            logUser : $('#log4j\\.appender\\.DATABASE\\.user').val(),
            logPassword : $('#log4j\\.appender\\.DATABASE\\.password').val(),
            md5Key : $('#md5Key').val(),
            desKey : $('#desKey').val(),
            csPolling : $('#csPolling').val(),
            csPay : $('#csPay').val()
        },function(data){
            $('#msg-dialog p').text(data.msg);
            $('.ui-dialog-buttonset .button').removeAttr("disabled")
        },"json")
    })

    var msgDialog = $('#msg-dialog').dialog({
        resizable: false,
        autoOpen: false,
        title: "系统消息",
        height: "auto",
        width: 400,
        closeOnEscape:false,
        modal: true,
        open: function(event,ui){
            $(".ui-dialog-titlebar-close").hide();
        },
        buttons: {
            " 确 定 ": function() {
                $( this ).dialog( "close" );
            }
        }
    })
})