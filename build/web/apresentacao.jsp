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
        <link href="css/imgEvento.css" rel="stylesheet">
        
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
        </script>

        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <jsp:include page = "menu_superior.jsp" />
        <div class="bread_area">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <ol class="breadcrumb">
                            <li><a href="index.jsp" title="Post">Home</a></li>
                            <li class="active">Apresentação</li>
                        </ol>                    
                    </div>
                </div>
            </div>
        </div>
        <main class="site-main page-main">
            <div class="container">
                <div class="row">
                    <section class="page col-sm-14">
                        <div class="media-left">
                            <h2 class="page-title">APRESENTAÇÃO DO CENTRO</h2>
                            <b>Diretoria do Centro: </b>Prof. Dr. Roberto Rodrigues de Souza
                            <br>
                            <b>Vice-Diretoria do Centro: </b>Prof. Dr. Edward David Moreno Ordonez
                            <br>
                            <br>
                            <b>Telefone(s):</b>
                            <br>
                            Secretaria: (55)(79) 3194-6684<br>
                            Diretor: (55)(79) 3194-6685<br>
                            E-mail Secretaria: secretaria.ccet@ufs.br<br>
                            E-mail Direção: direcao.ccet@ufs.br
                            <br>
                            <br>
                            <b>Endereço Alternativo: </b><a target="_blank" href="https://www.sigaa.ufs.br/sigaa/public/centro/lista_departamentos.jsf?lc=pt_BR&id=80">Acessar SIGAA</a>
                        </div>
                        <div class="media-right">
                            <a target="_blank" href="img/apresentacao2.jpg" class="media-left">
                                <img id="imgEvt2" class="media-object" src="img/apresentacao2.jpg">
                            </a>
                        </div>
                    </section>
                </div>
            </div>
        </main>
        <jsp:include page = "footer.jsp" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>