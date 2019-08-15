<%@page import="java.util.List"%>
<%@page import="Model.Evento"%>
<!DOCTYPE html>

<%
    List<Evento> listaSolicitados = null;
    
    if (session.getAttribute("listEvtsSolicit") != null) {
        
        listaSolicitados = (List<Evento>) session.getAttribute("listEvtsSolicit");
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
            
            function limparErrosData() {

                document.getElementById('divErroData').style.display = "none";
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
                        <h3 class="category-title">EVENTOS SOLICITADOS</h3>
                        
                        <%
                            if (listaSolicitados.size() == 0) {
                        %>
                        <h3 style="color: red">NENHUM EVENTO SOLICITADO</h3>
                        <%
                            }
                        %>
                        
                        <%
                            for (Evento evento : listaSolicitados) {
                                
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
                                        
                                        // Tratamento da hora de início
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
                                    <a style="color: blue;" href="ServletGetValidarEvento?idValidar=<%=evento.getId()%>">Analisar Evento <i class="glyphicon glyphicon-pencil"></i></a>
                                    <br>
                                    <br>
                                    <aside class="meta category-meta">
                                        <div class="pull-left">
                                            <div class="arc-comment"><h5 style="color: #000000">Data: <%=evento.getData()%></h5></div>
                                            <div class="arc-date"><h5 style="color: #000000">Horário: <%=horaInicio%></h5></div>
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
                                <li><a href="ServletFiltrarEventosDpt?dpt=0" title="">EXIBIR TODOS</a></li>
                                <li class="dropdown">
                                    <a title="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">POR DEPARTAMENTO <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="ServletFiltrarEventosDpt?dpt=1">DPT. DE CIÊNCIA E ENGENHARIA DE MATERIAIS</a></li>
                                        <li><a href="ServletFiltrarEventosDpt?dpt=2">DPT. DE COMPUTAÇÃO</a></li>
                                        <li><a href="ServletFiltrarEventosDpt?dpt=3">DPT. DE ENGENHARIA AMBIENTAL</a></li>
                                        <li><a href="ServletFiltrarEventosDpt?dpt=4">DPT. DE ENGENHARIA CIVIL</a></li>
                                        <li><a href="ServletFiltrarEventosDpt?dpt=5">DPT. DE ENGENHARIA DE PRODUÇÃO</a></li>
                                        <li><a href="ServletFiltrarEventosDpt?dpt=6">DPT. DE ENGENHARIA ELÉTRICA</a></li>
                                        <li><a href="ServletFiltrarEventosDpt?dpt=7">DPT. DE ENGENHARIA MECÂNICA</a></li>
                                        <li><a href="ServletFiltrarEventosDpt?dpt=8">DPT. DE ENGENHARIA QUÍMICA</a></li>
                                        <li><a href="ServletFiltrarEventosDpt?dpt=9">DPT. DE ESTATÍSTICA E CIÊNCIAS ATUARIAIS</a></li>
                                        <li><a href="ServletFiltrarEventosDpt?dpt=10">DPT. DE FÍSICA</a></li>
                                        <li><a href="ServletFiltrarEventosDpt?dpt=11">DPT. DE GEOLOGIA</a></li>
                                        <li><a href="ServletFiltrarEventosDpt?dpt=12">DPT. DE MATEMÁTICA</a></li>
                                        <li><a href="ServletFiltrarEventosDpt?dpt=13">DPT. DE QUÍMICA</a></li>
                                        <li><a href="ServletFiltrarEventosDpt?dpt=14">DPT. DE TECNOLOGIA DE ALIMENTOS</a></li>
                                        <li><a href="ServletFiltrarEventosDpt?dpt=15">NÚCLEO DE ENGENHARIA DE PETRÓLEO</a></li>
                                        <li><a href="ServletFiltrarEventosDpt?dpt=16">DIREÇÃO DO CCET</a></li>
                                        <!--<li><a href="ServletFiltrarEventosDpt?dpt=-1">EMPRESA JÚNIOR DA UFS</a></li>-->
                                        <!--<li><a href="ServletFiltrarEventosDpt?dpt=-2">ÓRGÃO EXTERNO À UFS</a></li>-->
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a title="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">PELO TIPO DO EVENTO <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="ServletFiltrarEvtsSolicitadosPeloTipoEvt?tipoEvtSolict=1">Palestra</a></li>
                                        <li><a href="ServletFiltrarEvtsSolicitadosPeloTipoEvt?tipoEvtSolict=2">Seminário</a></li>
                                        <li><a href="ServletFiltrarEvtsSolicitadosPeloTipoEvt?tipoEvtSolict=3">Congresso</a></li>
                                        <li><a href="ServletFiltrarEvtsSolicitadosPeloTipoEvt?tipoEvtSolict=4">Simpósio</a></li>
                                        <li><a href="ServletFiltrarEvtsSolicitadosPeloTipoEvt?tipoEvtSolict=5">Minicurso</a></li>
                                        <li><a href="ServletFiltrarEvtsSolicitadosPeloTipoEvt?tipoEvtSolict=6">Apresentação de Projeto ou Estágio</a></li>
                                        <li><a href="ServletFiltrarEvtsSolicitadosPeloTipoEvt?tipoEvtSolict=7">Apresentação de TCC</a></li>
                                        <li><a href="ServletFiltrarEvtsSolicitadosPeloTipoEvt?tipoEvtSolict=8">Defesa de Mestrado</a></li>
                                        <li><a href="ServletFiltrarEvtsSolicitadosPeloTipoEvt?tipoEvtSolict=9">Defesa de Doutorado</a></li>
                                        <li><a href="ServletFiltrarEvtsSolicitadosPeloTipoEvt?tipoEvtSolict=10">Outro</a></li>
                                    </ul>
                                </li>
                                <hr>
                                <form method="POST" action="ServletFiltrarEvtsSolicitadosPelaData" id="formulario" name="formulario">
                                    <h6 style="color: black">PELA DATA</h6>
                                    <div class="row form-group">
                                        <div class="col-sm-10">
                                            <input type="date" onchange="return limparErrosData()" class="form-control" id="inpDataEvento" name="inpDataEvento">
                                            <span style="color: red; display: none;" id="divErroData">Data incompleta ou inválida.</span>
                                        </div>
                                        <div class="col-sm-1">
                                            <button onclick="return validaData();" type="submit" class="btn btn-info"><i class="fa fa-search"></i></button>
                                        </div>
                                    </div>
                                </form>
                            </ul>
                        </div>
                    </aside>
                </div>
            </div>
        </main>
        <jsp:include page = "footer.jsp" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>