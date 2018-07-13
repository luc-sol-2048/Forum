
(function ($) {

    $("#contactForm").on('click', 'button', function(){
            var errors =false;
            $(".errors").remove();


            if($("#m_title").val() === ""){
                $("#m_title").before( "<span class='errors'> Wprowadź tytuł! </span> ");
                errors= true;
            }

            if($("#m_content").val() === "") {
                $("#m_content").before("<span class='errors'> Wprowadź treść! </span> ");
                errors=true;
            }
            return !errors;
        }
    );

})(jQuery)
