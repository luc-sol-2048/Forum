
(function ($) {

    $("#registerForm").on('click', 'button', function () {

            var errors = false;
            var emailReg = /^([a-zA-Z0-9\\.]+)@([a-zA-Z0-9\\-\\_\\.]+)\.([a-zA-Z0-9]+)$/i;
            $(".errors").remove();

            if ($("#r_firstName").val() === "") {
                $("#r_firstName").before("<span class='errors'> Wprowadź imię! </span> ");
                errors = true;
            }
            if ($("#r_name").val() === "") {
                $("#r_name").before("<span class='errors'> Wprowadź treść! </span> ");
                errors = true;
            }
            if ($("#r_email").val() === "") {
                $("#r_email").before("<span class='errors'> Wprowadź email! </span> ");
                errors = true;
            }else if(!emailReg.test($("#r_email").val())){
                $("#r_email").before( "<span class='errors'> Nieprawidłowy email! </span> ")
                errors = true;
            }
            if ($("#r_password").val() === "") {
                $("#r_password").before("<span class='errors'> Wprowadź hasło! </span> ");
                errors = true;
            }else if($("#r_password").val().length<6){
                $("#r_password").before("<span class='errors'> Hasło musi zawierać minimum 6 znaków! </span> ");
                errors = true;
            }

            return !errors;
        }
    );

})(jQuery)
