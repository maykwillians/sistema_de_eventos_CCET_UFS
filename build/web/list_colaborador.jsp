<%@page import="Model.Colaborador"%>
<%@page import="java.util.List"%>
<%@page import="Model.Evento"%>
<!DOCTYPE html>

<%
    List<Colaborador> listColaboradores = null;
    
    if (session.getAttribute("listColaboradores") != null) {
        
        listColaboradores = (List<Colaborador>) session.getAttribute("listColaboradores");
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
            
            function confirmarExcluir() {

                if (!confirm("Tem certeza que deseja excluir?")) {

                    return false;
                }
            };
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
                            <li class="active">Usuários Cadastrados</li>
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
                            if (listColaboradores.size() == 0) {
                        %>
                        <h3 style="color: red">NENHUM USUÁRIO CADASTRADO</h3>
                        <%
                            }
                        %>
                        
                        <%
                            for (Colaborador colaborador : listColaboradores) {
                        %>
                        <ul style="padding: 15px; background-color: #f2f2f2" class="media-list">
                            <li class="media">
                                <div class="media-body">
                                    <h5 style="color: black" class="media-heading"><%=colaborador.getNome()%></h5>
                                    <h7 style="color: black" class="media-heading"><%=colaborador.getEmail()%></h7>
                                    <br>
                                    <h7 style="color: #c9302c"><%=colaborador.getNomeDpt()%></h7>
                                </div>
                                <div class="media-right">
                                    <form role="form" method="POST" action="ServletDeleteColaborador" onsubmit="alert('Excluído com sucesso!');">
                                        <div class="form-group">
                                            <div class="form-horizontal">
                                                <button class="btn btn-danger" type="submit" value="<%=colaborador.getId()%>" onclick="return confirmarExcluir();" id="colaborador" name="colaborador"><i class="glyphicon glyphicon-trash"></i></button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </li>
                        </ul>
                        <%
                            }
                        %>
                    </section>
                    <aside class="sidebar col-sm-3">
                        <div class="widget">
                            <h4>MENU</h4>
                            <ul>
                                <li><a href="add_colaborador.jsp" title="">NOVO USUÁRIO</a></li>
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