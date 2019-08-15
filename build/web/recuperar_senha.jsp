<!DOCTYPE html>

<%
    String erro = "";
    String str = "";
    if (session.getAttribute("msg") != null) {

        str = session.getAttribute("msg").toString();

        if (str.equals("sim")) {

            erro = "Sua senha foi enviada para o seu e-mail.";
        }

        if (str.equals("nao")) {

            erro = "Erro: este e-mail não está cadastrado.";
        }
    }
%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>CCET - UFS</title>

        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600&amp;subset=latin-ext" rel="stylesheet">

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="style.css" rel="stylesheet">

        <link href="css/login.css" rel="stylesheet">
        <link href="css/footer.css" rel="stylesheet">

        <script Language="JavaScript">
            
            (function() {
                if( window.localStorage ) {
                    if( !localStorage.getItem( 'firstLoad' ) ) {
                        
                        localStorage[ 'firstLoad' ] = true;
                        window.location.reload();
                        
                        // Lógica de alert próprio da página
                        var aux = "<%=str%>";
                        if (aux != "") {
                            
                            alert("<%=erro%>");
                        }
                        <%
                            session.removeAttribute("msg");
                        %>
                    } else
                        localStorage.removeItem( 'firstLoad' );
                }
            })();
            
            function validaCampos() {
                
                // Valida e-mail ----------------------------------------------
                var email = document.getElementById('email').value;
                var er = new RegExp(/^[a-z0-9_\-\.]+@[a-z0-9_\-\.]{2,}\.[a-z0-9]{2,}(\.[a-z0-9])?/);

                if (!er.test(email)) {

                    document.formulario.email.focus();
                    document.getElementById('divErroEmail').style.display = "block";
                    return false;
                }
            }
            ;
            
            function limparErrosEmail() {

                document.getElementById('divErroEmail').style.display = "none";
            }
            ;
        </script>

        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <jsp:include page = "menu_superior.jsp" />
        <main class="site-main"><div class="container" style="margin-top:40px">
                <div class="row">
                    <div class="col-sm-6 col-md-4 col-md-offset-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <strong class="">CCET EVENTOS - RECUPERAR SENHA</strong>
                            </div>
                            <div class="panel-body">
                                <form role="form" action="ServletRecuperarSenha" id="formulario" name="formulario" method="POST">
                                    <fieldset>
                                        <div class="row">
                                            <div class="col-sm-12 col-md-10  col-md-offset-1 ">
                                                <div class="form-group">
                                                    <br>
                                                    <b style="color: black">Enviaremos sua senha para o seu e-mail</b>
                                                    <br>
                                                    <br>
                                                    <div class="input-group">
                                                        <span class="input-group-addon">
                                                            <i class="glyphicon glyphicon-user"></i>
                                                        </span>
                                                        <input class="form-control" onchange="return limparErrosEmail()" placeholder="Insira seu e-mail" id="email" name="email" type="text" maxlength="64">
                                                    </div>
                                                    <span style="color: red; display: none" id="divErroEmail">E-mail inválido.</span>
                                                </div>
                                                <div class="form-group">
                                                    <input type="submit" id="enviar" name="enviar" onclick="return validaCampos();" value="Recuperar Senha" class="btn btn-lg btn-primary btn-block">
                                                </div>
                                            </div>
                                        </div>
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <jsp:include page = "footer.jsp" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript">
            $('.carousel[data-type="multi"] .item').each(function () {
                var next = $(this).next();
                if (!next.length) {
                    next = $(this).siblings(':first');
                }
                next.children(':first-child').clone().appendTo($(this));

                for (var i = 0; i < 4; i++) {
                    next = next.next();
                    if (!next.length) {
                        next = $(this).siblings(':first');
                    }

                    next.children(':first-child').clone().appendTo($(this));
                }
            });
        </script>
    </body>
</html>