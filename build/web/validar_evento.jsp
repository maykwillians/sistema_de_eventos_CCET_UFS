<%@page import="Model.Evento"%>
<!DOCTYPE html>

<%
    Evento evento = null;

    String urlImage = "";
    String tipoEvento = "";
    
    int a;
    int b;

    String x;
    String y;

    String k;
    String l;

    String horaInicio = "";

    int a2;
    int b2;

    String x2;
    String y2;

    String k2;
    String l2;

    String duracao = "";

    if (session.getAttribute("evtParaValidar") != null) {

        evento = (Evento) session.getAttribute("evtParaValidar");

        urlImage = evento.getUrlImg();
        tipoEvento = "";
        
        // Tratamento do tipo do evento
        switch (evento.getTipo()) {
            case 1:
                tipoEvento = "Palestra";
                break;
            case 2:
                tipoEvento = "Seminário";
                break;
            case 3:
                tipoEvento = "Congresso";
                break;
            case 4:
                tipoEvento = "Simpósio";
                break;
            case 5:
                tipoEvento = "Minicurso";
                break;
            case 6:
                tipoEvento = "Apresentação de Projeto ou Estágio";
                break;
            case 7:
                tipoEvento = "Apresentação de TCC";
                break;
            case 8:
                tipoEvento = "Defesa de Mestrado";
                break;
            case 9:
                tipoEvento = "Defesa de Doutorado";
                break;
            case 10:
                tipoEvento = "Outro";
                break;
        }

        // Tratamento da hora de início
        a = evento.getHoraInicio() % 60;
        b = evento.getHoraInicio() / 60;

        x = a + "";
        y = b + "";

        k = x;
        l = y;

        if (x.length() == 1) {

            k = "0" + x;
        }

        if (y.length() == 1) {

            l = "0" + y;
        }

        horaInicio = l + ":" + k + "hs";

        // Tratamento da duração
        a2 = evento.getDuracao() % 60;
        b2 = evento.getDuracao() / 60;

        x2 = a2 + "";
        y2 = b2 + "";

        k2 = x2;
        l2 = y2;

        if (x2.length() == 1) {

            k2 = "0" + x2;
        }

        if (y2.length() == 1) {

            l2 = "0" + y2;
        }

        duracao = l2 + "h" + k2 + "m";
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

        <link href="css/footer.css" rel="stylesheet">
        <link href="css/imgEvento.css" rel="stylesheet">

        <script type="text/javascript">
            (function () {
                if (window.localStorage) {
                    if (!localStorage.getItem('firstLoad')) {
                        localStorage[ 'firstLoad' ] = true;
                        window.location.reload();
                    } else
                        localStorage.removeItem('firstLoad');
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
                            <li><a href="controle_eventos.jsp" title="Post">Eventos Solicitados</a></li>
                            <li class="active">Evento Solicitado</li>
                        </ol>                    
                    </div>
                </div>
            </div>
        </div>
        <main class="site-main category-main">
            <div class="container">
                <div class="row">
                    <section class="category-content col-sm-9">
                        <h2 class="category-title">EVENTO SOLICITADO</h2>
                        <ul class="media-list">
                            <li class="media">
                                <a target="_blank" href="<%=urlImage%>" class="media-left">
                                    <img style="margin-right: 12px" id="imgEvt" class="media-object" src="<%=urlImage%>">
                                </a>
                                <div class="media-body">
                                    <h3 class="media-heading"><b><%=evento.getNome()%></b></h3>
                                    <br>
                                    <b>Tipo do Evento: </b> <%=tipoEvento%>
                                    <br>
                                    <br>
                                    <b>Solicitado por: </b> <%=evento.getNomeCriador()%> (<%=evento.getEmailCriador()%>)
                                    <br>
                                    <b style="color: #c9302c" ><%=evento.getNomeDpt()%></b>
                                    <br>
                                    <br>
                                    <b>Data do Evento: </b> <%=evento.getData()%>
                                    <br>
                                    <br>
                                    <b>Horário do Evento: </b> <%=horaInicio%>
                                    <br>
                                    <br>
                                    <b>Duração: </b> <%=duracao%>
                                    <br>
                                    <br>
                                    <b>Local do Evento: </b> <%=evento.getLocal()%>
                                    <br>
                                    <br>
                                    <b>Organizador(a) do Evento: </b> <%=evento.getNomeResponsavel()%> (<%=evento.getEmailResponsavel()%>)
                                    <br>
                                    <br>
                                    <b>Descrição do Evento: </b> <%=evento.getResusmo()%>
                                    <br>
                                    <hr>
                                    <form role="form" method="POST" action="ServletValidarEvento" onsubmit="alert('Salvo com sucesso!');">
                                        <div class="form-group">
                                            <div class="form-horizontal">
                                                <button style="margin-right: 10px" onclick="return confirmValidar();" type="submit" class="btn btn-danger" value="<%=evento.getId()%>" id="reprovar" name="reprovar">REPROVAR</button>
                                                <button onclick="return confirmValidar();" type="submit" class="btn btn-primary" value="<%=evento.getId()%>" id="aprovar" name="aprovar">APROVAR</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </li>
                        </ul>
                    </section>
                    <aside class="sidebar col-sm-3">
                        <div class="widget">
                            <h4>OPÇÕES DE ADMINISTRADOR</h4>
                            <ul>
                                <!--<li><a href="#" title="">EXCLUIR EVENTO</a></li>-->
                            </ul>
                        </div>
                    </aside>
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

            function confirmValidar() {

                if (!confirm("Tem certeza?")) {

                    return false;
                }
            }
            ;
        </script>
    </body>
</html>