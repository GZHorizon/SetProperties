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
            var jdbcHtml =  '<li class="row"><label class="btn  btn-info col-md-2" disabled>jdbc.driver</label><input class="form-control col-md-5" id="jdbcDriver" value="'+data.jdbcvo.driver+'"/></li>'+
                            '<li class="row"><label class="btn  btn-info col-md-2" disabled>jdbc.url</label><input class="form-control col-md-5" id="jdbcUrl" value="'+data.jdbcvo.url+'"/></li>'+
                            '<li class="row"><label class="btn  btn-info col-md-2" disabled>jdbc.user</label><input class="form-control col-md-5" id="jdbcUser" value="'+data.jdbcvo.user+'"/></li>'+
                            '<li class="row"><label class="btn  btn-info col-md-2" disabled>jdbc.password</label><input class="form-control col-md-5" id="jdbcPassword" value="'+data.jdbcvo.password+'"/></li>';
            $('#jdbc').html(jdbcHtml)

            var logHtml =   '<li class="row"><label class="btn  btn-info col-md-3" disabled>log4j.appender.DATABASE.driver</label><input class="form-control col-md-5" id="logDriver" value="'+data.logvo.driver+'"/></li>'+
                            '<li class="row"><label class="btn  btn-info col-md-3" disabled>log4j.appender.DATABASE.URL</label><input class="form-control col-md-5" id="logUrl" value="'+data.logvo.URL+'"/></li>'+
                            '<li class="row"><label class="btn  btn-info col-md-3" disabled>log4j.appender.DATABASE.user</label><input class="form-control col-md-5" id="logUser" value="'+data.logvo.user+'"/></li>'+
                            '<li class="row"><label class="btn  btn-info col-md-3" disabled>log4j.appender.DATABASE.password</label><input class="form-control col-md-5" id="logPassword" value="'+data.logvo.password+'"/></li>';
            $('#log').html(logHtml)
            if(data.thirdrechargevo.md5Key != null && data.thirdrechargevo.md5Key != "null" && data.thirdrechargevo.md5Key != undefined && data.thirdrechargevo.md5Key != ""){
                var thirdrechargeHtml =     '<li class="row"><label class="btn  btn-info col-md-2" disabled>md5Key</label><input class="form-control col-md-2" id="md5Key" value="'+data.thirdrechargevo.md5Key+'"/></li>'+
                                            '<li class="row"><label class="btn  btn-info col-md-2" disabled>desKey</label><input class="form-control col-md-2" id="desKey" value="'+data.thirdrechargevo.desKey+'"/></li>'+
                                            '<li class="row"><label class="btn  btn-info col-md-2" disabled>csPolling</label><input class="form-control col-md-2" id="csPolling" value="'+data.thirdrechargevo.csPolling+'"/></li>'+
                                            '<li class="row"><label class="btn  btn-info col-md-2" disabled>csPay</label><input class="form-control col-md-2" id="csPay" value="'+data.thirdrechargevo.csPay+'"/></li>';
                $('#thirdrecharge').html(thirdrechargeHtml)
            }
        })
    })

    $('#save').on('click',function(){
        $('#msg-dialog p').text("正在修改配置文件，请稍等......");
        $('.ui-dialog-buttonset .button').attr({disabled: "disabled"})
        msgDialog.dialog('open');
        var url = $('#installation-path').val();
        var jdbcDriver = $('#jdbcDriver').val();
        var jdbcUrl = $('#jdbcUrl').val();
        var jdbcUser = $('#jdbcUser').val();
        var jdbcPassword = $('#jdbcPassword').val();
        var logDriver = $('#logDriver').val();
        var logUrl = $('#logUrl').val();
        var logUser = $('#logUser').val();
        var logPassword = $('#logPassword').val();
        var md5Key = $('#md5Key').val();
        var desKey = $('#desKey').val();
        var csPolling = $('#csPolling').val();
        var csPay = $('#csPay').val();

        $.post("saveProperties.do",{
            url : url,
            jdbcDriver : jdbcDriver,
            jdbcUrl : jdbcUrl,
            jdbcUser : jdbcUser,
            jdbcPassword : jdbcPassword,
            logDriver : logDriver,
            logUrl : logUrl,
            logUser : logUser,
            logPassword : logPassword,
            md5Key : md5Key,
            desKey : desKey,
            csPolling : csPolling,
            csPay : csPay
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