<!DOCTYPE html>
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

        <link href="css/footer.css" rel="stylesheet">

        <script type="text/javascript">
            
            (function() {
                if( window.localStorage ) {
                    if( !localStorage.getItem( 'firstLoad' ) ) {
                        localStorage[ 'firstLoad' ] = true;
                        window.location.reload();
                    } else
                        localStorage.removeItem( 'firstLoad' );
                }
            })();
            
            function validaCampos() {

                // Valida nome e e-mail
                // Recebe nome
                var nome = document.getElementById('nomeVisitante').value;
                while (nome.indexOf(" ") !== -1) {

                    nome = nome.replace(" ", "");
                }
                // Recebe e-mail
                var email = document.getElementById('emailVisitante').value;
                var er = new RegExp(/^[a-z0-9_\-\.]+@[a-z0-9_\-\.]{2,}\.[a-z0-9]{2,}(\.[a-z0-9])?/);

                // Valida --------------------------------------------------
                if ((nome.length < 5) & (!er.test(email))) {

                    document.formulario.nomeVisitante.focus();
                    document.getElementById('divErroNomeEmail').style.display = "block";
                    return false;
                }


                // Valida nome --------------------------------------------------
                if (nome.length < 5) {

                    document.formulario.nomeVisitante.focus();
                    document.getElementById('divErroNome').style.display = "block";
                    return false;
                }

                // Valida e-mail --------------------------------------------------
                if (!er.test(email)) {

                    document.formulario.emailVisitante.focus();
                    document.getElementById('divErroEmail').style.display = "block";
                    return false;
                }
            }
            ;

            function limparErrosNomeEmail() {

                limparErrosNome();
                limparErrosEmail();
                document.getElementById('divErroNomeEmail').style.display = "none";
            }
            ;

            function limparErrosNome() {

                document.getElementById('divErroNome').style.display = "none";
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
        <main class="site-main">
            <section class="hero_area">
                <div class="hero_content">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-12">
                                <h1>CCET</h1>
                                <h2>Centro de Ciências Exatas e Tecnologia</h2>
                                <br>
                            </div>
<!--                            <div class="col-sm-5">
                                <h5 style="color: #000000">Deseja receber e-mails do CCET ou convidar um amigo para acompanhar os nossos eventos?</h5>
                                <div class="clearfix"></div>
                                <div class="login-form-1" >
                                    <form id="formulario" name="formulario" class="text-left" action="ServletVisitante" method="POST" onsubmit="alert('Obrigado por se cadastrar! A partir de agora você poderá receberá e-mails sobre novos eventos e notícias do CCET');">
                                        <form id="login-form" class="text-left" action="ServletVisitante" method="POST" onsubmit="alert('Obrigado por se cadastrar! A partir de agora você poderá receberá e-mails sobre novos eventos e notícias do CCET');">
                                        <div class="login-form-main-message"></div>
                                        <div class="main-login-form" >
                                            <div class="login-group" style="border: 1px solid #ccc">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" onchange="return limparErrosNomeEmail()" id="nomeVisitante" name="nomeVisitante" placeholder="Nome" maxlength="128">
                                                </div>
                                                <div class="form-group">
                                                    <input type="text" class="form-control" onchange="return limparErrosNomeEmail()" id="emailVisitante" name="emailVisitante" placeholder="E-mail" maxlength="64">
                                                </div>
                                            </div>
                                            <button type="submit" onclick="return validaCampos();" class="login-button"><i class="fa fa-envelope"></i></button>
                                        </div>
                                        <span style="color: red; display: none" id="divErroNome">Nome inexistente, inválido ou muito pequeno.</span>
                                        <span style="color: red; display: none" id="divErroEmail">E-mail inexistente ou inválido.</span>
                                        <span style="color: red; display: none" id="divErroNomeEmail">Nome e e-mail inexistentes ou inválidos.</span>
                                    </form>
                                </div>                            
                            </div>-->
                        </div>
                    </div>
                </div>
            </section>
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