<%@page import="java.util.List"%>
<%@page import="Model.Evento"%>
<!DOCTYPE html>

<%
    List<Evento> listaAprovados = null;
    
    if (session.getAttribute("listEvtsConfirm") != null) {
        
        listaAprovados = (List<Evento>) session.getAttribute("listEvtsConfirm");
    }
    
    String urlImage = "";
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
        
        <style type='text/css'>
            
        </style>
        
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
            
            function validaData() {
                
                // Valida a data --------------------------------------------------
                var data = document.getElementById('inpDataEvento').value;

                var dia = data.substr(0, 2);
                var mes = data.substr(3, 5);
                var ano = data.substr(6, data.length);

                if (dia == "" | dia == "00" | mes == "" | mes == "00" | ano == "" | ano == "0000") {

                    document.formulario.inpDataEvento.focus();
                    document.getElementById('divErroData').style.display = "block";
                    
                    return false;
                }
            };
            
            function validaPalavra() {
                
                // Valida a palavra chave --------------------------------------------------
                var pesquisa = document.getElementById('inpPalavra').value;

                while (pesquisa.indexOf(" ") !== -1) {

                    pesquisa = pesquisa.replace(" ", "");
                }

                if (pesquisa.length < 2) {

                    document.formularioPalavra.inpPalavra.focus();
                    document.getElementById('divErroPalavra').style.display = "block";
                    return false;
                }
            };
            
            function limparErrosData() {

                document.getElementById('divErroData').style.display = "none";
            }
            ;
            
            function limparErrosPalavra() {

                document.getElementById('divErroPalavra').style.display = "none";
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
        <div class="bread_area">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <ol class="breadcrumb">
                            <li><a href="index.jsp" title="Post">Home</a></li>
                            <li class="active">Eventos</li>
                        </ol>                    
                    </div>
                </div>
            </div>
        </div>
        <main class="site-main category-main">
            <div class="container">
                <div class="row">
                    <section class="category-content col-sm-9">
                        <%
                            if (listaAprovados.size() > 0) {
                                
                                if (listaAprovados.get(0).getStatus() == -1) {
                        %>
                        <h3 class="category-title">EVENTOS ANTERIORES</h3>
                        <%
                                }
                            }
                        %>
                        
                        <%
                            if (listaAprovados.size() > 0) {
                                
                                if (listaAprovados.get(0).getStatus() == 1) {
                        %>
                        <h3 class="category-title">EVENTOS CONFIRMADOS</h3>
                        <%
                                }
                            }
                        %>
                        
                        <%
                            if (listaAprovados.size() == 0) {
                        %>
                        <h3 style="color: red">NENHUM EVENTO</h3>
                        <%
                            }
                        %>
                        
                        <%
                            for (Evento evento : listaAprovados) {
                                
                            urlImage = evento.getUrlImg();
                        %>
                        <ul style="padding: 15px; background-color: #fcfcfc" class="media-list">
                        <!--<ul class="media-list">-->
                            <li class="media">
                                <div class="media-left">
                                    <a target="_blank" href="<%=urlImage%>">
                                        <img id="imgEvt" class="media-object" src="<%=urlImage%>" alt="Post">
                                    </a>
                                </div>
                                <div class="media-body">
                                    <h3 style="color: black" class="media-heading"><%=evento.getNome()%></h3>
                                    <h5 style="color: #c9302c" ><%=evento.getNomeDpt()%></h5>
                                    <br>
                                    <%
                                        String resumo = evento.getResusmo();
                                        
                                        if (evento.getResusmo().length() > 110) {
                                            
                                            resumo = evento.getResusmo().substring(0, 107) + "...";
                                        }
                                        
                                        // Tratamento da hora de in�cio
                                        int a = evento.getHoraInicio() % 60;
                                        int b = evento.getHoraInicio() / 60;

                                        String x = a + "";
                                        String y = b + "";

                                        String k = x;
                                        String l = y;

                                        if (x.length() == 1) {

                                            k = "0" + x;
                                        }

                                        if (y.length() == 1) {

                                            l = "0" + y;
                                        }

                                        String horaInicio = l + ":" + k + "hs";
                                    %>
                                    <!--<p id="pDescricao"><%=resumo%></p>-->
                                    <a style="color: blue;" href="ServletTratarExibirEvento?id=<%=evento.getId()%>">Ver Detalhes <i class="glyphicon glyphicon-search"></i></a>
                                    <br>
                                    <br>
                                    <aside class="meta category-meta">
                                        <div class="pull-left">
                                            <div class="arc-comment"><h5 style="color: #000000">Data: <%=evento.getData()%></h5></div>
                                            <div class="arc-comment"><h5 style="color: #000000">Hor�rio: <%=horaInicio%></h5></div>
                                            <div class="arc-date"><h5 style="color: #555; font-weight: bold;"><i class="fa fa-eye"></i> Visualiza��es: <%=evento.getAcessos()%></h5></div>
                                        </div>
                                    </aside>
                                </div>
                            </li>
                        </ul>
                        <br>
                        <%
                            }
                        %>
                    </section>
                    <aside class="sidebar col-sm-3">
                        <div class="widget">
                            <h4>FILTRAR EVENTOS</h4>
                            <ul>
                                <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=0" title="">EXIBIR TODOS</a></li>
                                <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=1000000" title="">MAIS VISUALIZADOS</a></li>
                                <li class="dropdown">
                                    <a title="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">POR DEPARTAMENTO <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=1">DPT. DE CI�NCIA E ENGENHARIA DE MATERIAIS</a></li>
                                        <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=2">DPT. DE COMPUTA��O</a></li>
                                        <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=3">DPT. DE ENGENHARIA AMBIENTAL</a></li>
                                        <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=4">DPT. DE ENGENHARIA CIVIL</a></li>
                                        <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=5">DPT. DE ENGENHARIA DE PRODU��O</a></li>
                                        <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=6">DPT. DE ENGENHARIA EL�TRICA</a></li>
                                        <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=7">DPT. DE ENGENHARIA MEC�NICA</a></li>
                                        <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=8">DPT. DE ENGENHARIA QU�MICA</a></li>
                                        <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=9">DPT. DE ESTAT�STICA E CI�NCIAS ATUARIAIS</a></li>
                                        <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=10">DPT. DE F�SICA</a></li>
                                        <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=11">DPT. DE GEOLOGIA</a></li>
                                        <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=12">DPT. DE MATEM�TICA</a></li>
                                        <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=13">DPT. DE QU�MICA</a></li>
                                        <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=14">DPT. DE TECNOLOGIA DE ALIMENTOS</a></li>
                                        <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=15">N�CLEO DE ENGENHARIA DE PETR�LEO</a></li>
                                        <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=16">DIRE��O DO CCET</a></li>
                                        <!--<li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=-1">EMPRESA J�NIOR DA UFS</a></li>-->
                                        <!--<li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=-2">�RG�O EXTERNO � UFS</a></li>-->
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a title="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">PELO TIPO DO EVENTO <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="ServletFiltrarEvtsConfirmadosPeloTipoEvt?tipoEvtConfirm=1">Palestra</a></li>
                                        <li><a href="ServletFiltrarEvtsConfirmadosPeloTipoEvt?tipoEvtConfirm=2">Semin�rio</a></li>
                                        <li><a href="ServletFiltrarEvtsConfirmadosPeloTipoEvt?tipoEvtConfirm=3">Congresso</a></li>
                                        <li><a href="ServletFiltrarEvtsConfirmadosPeloTipoEvt?tipoEvtConfirm=4">Simp�sio</a></li>
                                        <li><a href="ServletFiltrarEvtsConfirmadosPeloTipoEvt?tipoEvtConfirm=5">Minicurso</a></li>
                                        <li><a href="ServletFiltrarEvtsConfirmadosPeloTipoEvt?tipoEvtConfirm=6">Apresenta��o de Projeto ou Est�gio</a></li>
                                        <li><a href="ServletFiltrarEvtsConfirmadosPeloTipoEvt?tipoEvtConfirm=7">Apresenta��o de TCC</a></li>
                                        <li><a href="ServletFiltrarEvtsConfirmadosPeloTipoEvt?tipoEvtConfirm=8">Defesa de Mestrado</a></li>
                                        <li><a href="ServletFiltrarEvtsConfirmadosPeloTipoEvt?tipoEvtConfirm=9">Defesa de Doutorado</a></li>
                                        <li><a href="ServletFiltrarEvtsConfirmadosPeloTipoEvt?tipoEvtConfirm=10">Outro</a></li>
                                    </ul>
                                </li>
                                <br>
                                <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=-1000000" title=""><i class="fa fa-clock-o"></i> EVENTOS ANTERIORES</a></li>
                                <hr>
                                <form method="POST" action="ServletFiltrarEvtsConfirmadosPelaData" id="formulario" name="formulario">
                                    <h6 style="color: black">PESQUISAR PELA DATA</h6>
                                    <div class="row form-group">
                                        <div class="col-sm-10">
                                            <input type="date" onchange="return limparErrosData()" class="form-control" id="inpDataEvento" name="inpDataEvento">
                                            <span style="color: red; display: none;" id="divErroData">Data incompleta ou inv�lida.</span>
                                        </div>
                                        <div class="col-sm-1">
                                            <button onclick="return validaData();" type="submit" class="btn btn-info"><i class="fa fa-search"></i></button>
                                        </div>
                                    </div>
                                </form>
                                <hr>
                                <form method="POST" action="ServletFiltrarEvtsConfirmadosPorPalavra" id="formularioPalavra" name="formularioPalavra">
                                    <h6 style="color: black">PESQUISAR POR PALAVRA CHAVE</h6>
                                    <div class="row form-group">
                                        <div class="col-sm-10">
                                            <input type="text" onchange="return limparErrosPalavra()" class="form-control" id="inpPalavra" name="inpPalavra" placeholder="Insira sua pesquisa" maxlength="32">
                                            <span style="color: red; display: none;" id="divErroPalavra">Pesquisa inexistente ou inv�lida.</span>
                                        </div>
                                        <div class="col-sm-1">
                                            <button onclick="return validaPalavra();" type="submit" class="btn btn-info"><i class="fa fa-search"></i></button>
                                        </div>
                                    </div>
                                </form>
                                <hr>
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
        </script>
    </body>
</html>