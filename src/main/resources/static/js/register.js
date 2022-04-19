$().ready(function(){
    $(".gender").blur(function(){
        var gender = $("input:radio:checked").val();
        if(gender == ""){
            $("#tips_gender").text("至少选择一项");
            $("#tips_gender").css("color", "red");
            return false;
        }
        else{
            $("#tips_gender").text("OK!");
            $("#tips_gender").css("color", "black");
        }
    });

    $("#txtUser").blur(function(){
        var txtUser = $("#txtUser").val();
        if (txtUser.length < 6 || txtUser.length > 18) {
            $("#tips_username").text("用户名由6-18个字符组成");
            $("#tips_username").css("color", "red");
            return false;
        }
        else{
            $("#tips_username").text("OK!");
            $("#tips_username").css("color", "black");
        }
    });

    $("#txtPwd").blur(function(){
        var reg = /[^A-Za-z0-9_] + /;
        var regs = /[^A-Za-z0-9_\u4e00 - \u9fa5] + $ /;

        var p = $("#txtPwd").val();
        var pwd = $.trim(p);

        if (pwd.length < 6 || pwd.length > 18 || regs.test(pwd) ){
            $("#tips_password").text("密码由6-18个字符组成，并且包含字母，数字和标点符号");
            $("#tips_password").css("color", "red");
            return false;
        }else{
            $("#tips_password").text("OK!");
            $("#tips_password").css("color", "black");
        }
    });

    $("#txtRpt").blur(function(){
        var rpt = $("#txtRpt").val();
        var rePwd = $.trim(rpt);
        var p = $("#txtPwd").val();
        var pwd = $.trim(p);
        if (rePwd !== pwd) {
            $("#tips_repeat").text("密码不一致");
            $("#tips_repeat").css("color", "red");
            return false;
        } else{
            $("#tips_repeat").text("OK!");
            $("#tips_repeat").css("color", "black");
        }
    });

    $("#selUser").blur(function(){
        var sel = $("#selUser").val();
        if (sel == null) {
            $("#tips_usertype").text("没有选择用户类型");
            $("#tips_usertype").css("color", "red");
            return false;
        }
        else if(sel == "u" || sel == "m"){
            $("#tips_usertype").text("OK!");
            $("#tips_usertype").css("color", "black");
        }
    });

    $("#txtMail").blur(function(){
        var email = $("#txtMail").val();
        var pattern = /^[a-zA-Z0 -9#_\^\$\.\*\+\-\?\=\\\!\:\(\)\{\}\]+@[a-zA-Z0-9] +((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
        if(email.length == 0){
            $("#tips_email").text("电子邮箱不能为空");
            $("#tips_email").css("color", "red");
            return false;
        }else if(! pattern.test(email)){
            $("#tips_email").text("Email不合法");
            $("#tips_email").css("color", "red");
            return false;
        }else{
            $("#tips_email").text("OK!");
            $("#tips_email").css("color", "black");
        }
    });

    $("#txtIntro").blur(function(){
        var intro = $("#txtIntro").val();
        if(intro.length > 100){
            $("#tips_introduction").text("长度不能超过100个字符");
            $("#tips_introduction").css("color", "red");
            return false;
        }else{
            $("#tips_introduction").text("OK!");
            $("#tips_introduction").css("color", "black");
        }
    });

    $(".hobby").blur(function(){
        var hobby = [];
        $("input[class='hobby':checked").each(function(){
            hobby.push($(this).val);
        })
        if(hobby.length > 0){
            $("#tips_hobby").text("OK!");
            $("#tips_hobby").css("color", "black");
        } else {
            $("#tips_hobby").text("至少选择其中一项");
            $("#tips_hobby").css("color", "red");
            return false;
        }
    });

    /*$("#registerForm").submit({
        url : "http://localhost:8080/re",
        datatype: json,
        callback: function (data){
            data = eval("(" + data + ")")
            alert(data.content);
        },
        before: function (){

        }
    }).submit();*/
   /* $("#submit").click(function(){
        $.post("http://localhost:8080/re",{
            username : $("#txtUser").val(),
            password : $("#txtPwd").val(),
            type : $("#selUser").val(),
            gender : $("input:radio:checked").val(),
            hobby : $("input[class='hobby':checked").each(),
            email : $("#txtMail").val(),
            info : $("#txtIntro").val()
        },function(){
            alert("数据\n"+data+"\n状态："+statusbar);
        })
    })*/
});
const data = JSON.stringify({
    "m_userName": $("#txtUser").val(),
    "m_password": $("#txtPwd").val()
});
function load(){
    var xhr = new XMLHttpRequest;
    xhr.open('POST', 'http://localhost:8080/re', true);
    xhr.setRequestHeader("Content-Type","application/json;charset=utf8");
    xhr.onreadystatechange = function (){
        if (xhr.readyState === 4 && xhr.status === 200){
            console.log(xhr.responseText);
        }
    }
    xhr.send(data);
}

/*
function checkGender(){
    var genderNum = document.getElementByName('gender');
    var gender = "";
    for (var i = 0; i < genderNum; ++i) {
        if (genderNum[i].checked) {
            gender = genderNum[i].value;
            
        }
    }
    if(gender == ""){
        document.getElementById("tips_gender").innerHTML = "<em style='color: #FF0000'>至少选择一项</em>";
        return false;
    }
    else{
        document.getElementById("tips_gender").innerHTML = "OK!"
    }
}
function checkName(){
    if (document.getElementById("txtUser").value.length < 6 || document.getElementById("txtUser").value.length > 18) {
        document.getElementById("tips_username").innerHTML = "<em style='color: #FF0000'>用户名由6-18个字符组成</em>";
        document.getElementById("txtUser").focus();
        return false;
    }
    else{
        document.getElementById("tips_username").innerHTML = "OK!"
    }
}

function checkPWD(){    
    var reg = /[^A-Za-z0-9_] + /;
    var regs = /[^A-Za-z0-9_\u4e00 - \u9fa5] + $ /;
    if (document.getElementById("txtPwd").value.length < 6 || document.getElementById("txtPwd").value.length > 18 || regs.test(document.getElementById("txtPwd").value) ){
    document.getElementById("tips_password").innerHTML = "<em style='color: #FF0000'>密码由6-18个字符组成，并且包含字母，数字和标点符号</em>"
    document.getElementById("txtPwd").focus();
    return false;
    }else{
    document.getElementById("tips_password").innerHTML = "OK!";
    }
}

function checkRpt(){
    if (document.getElementById("txtRpt").value != document.getElementById("txtPwd").value) {
        document.getElementById("tips_repeat").innerHTML = "<em style='color: #FF0000'>密码不一致</em>"
        document.getElementById("txtRpt").focus();
        return false;
    }
    else{
        document.getElementById("tips_repeat").innerHTML = "OK!";
    }
}

function checkUser(){
    if (document.getElementById("selUser").selectedIndex == 0) {
        document.getElementById("tips_usertype").innerHTML = "<em style='color: #FF0000'>没有选择用户类型</em>";
        document.getElementById("selUser").focus();
        return false;
    }
    else{
        document.getElementById("tips_usertype").innerHTML = "OK!";
    }

}

function checkEmail(){
    var email = document.getElementById("txtMail").value;
    var pattern = /^[a-zA-Z0 -9#_\^\$\.\*\+\-\?\=\\\!\:\(\)\{\}\]+@[a-zA-Z0-9] +((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
    if(email.length == 0){
        document.getElementById("tips_email").innerHTML="<em style='color: #FF0000'>电子邮箱不能为空</em >" ;
        document.getElementById("txtMail").focus();
        return false;
    }else if(! pattern.test(email)){
        document.getElementById("tips_email" ).innerHTML="<em style='color: #FF0000'>Email不合法</em>";
        document.getElementById("txtMail").focus();
        return false;
    }
    else{
        document.getElementById("tips_email").innerHTML = "OK!";
    }

}
function checkIntro(){
    if(document.getElementById("txtIntro").value.length > 100){
        document.getElementById("tips_introduction" ).innerHTML="<em style='color: #FF0000'>长度不能超过100个字符</em>";
        document.getElementById("txtIntro").focus();
        return false;
    }else{
        document.getElementById("tips_introduction" ).innerHTME = "OK!";
    }
}

function changeHobby()
{
    var hobby = 0;
    var objNum =document.getElementsByName("hobby");
    for(var i=0;i< objNum.length;++i){
        if(objNum[i].checked == true){
            hobby++;
        }
    }
    if(hobby > 0){
        document.getElementById("tips_hobby").innerHTML ="OK!";
    }else{
        document.getElementById("tips_hobby").innerHTML="<em style='color: #FF0000'>至少选择其中一项</em>";
        return false;
    }
}
*/