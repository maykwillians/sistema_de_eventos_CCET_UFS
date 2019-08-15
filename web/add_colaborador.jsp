
<!DOCTYPE html>
<%
    String erro = "";
    String str = "";
    if (session.getAttribute("msgErroEmailUser") != null) {

        str = session.getAttribute("msgErroEmailUser").toString();

        if (str.equals("1")) {

            erro = "Usuário cadastrado com sucesso!";
        }

        if (str.equals("0")) {

            erro = "Erro: este usuário já está cadastrado.";
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
        <link href="css/footer.css" rel="stylesheet">
        
        <script type="text/javascript">
            
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
                            session.removeAttribute("msgErroEmailUser");
                        %>
                    } else
                        localStorage.removeItem( 'firstLoad' );
                }
            })();

            function validaCampos() {
                
                // Valida o nome do Usuário --------------------------------------------------
                var nomeUser = document.getElementById('inpNomeUser').value;

                while (nomeUser.indexOf(" ") !== -1) {

                    nomeUser = nomeUser.replace(" ", "");
                }

                if (nomeUser.length < 8) {

                    document.formulario.inpNomeUser.focus();
                    document.getElementById('divErroNomeUser').style.display = "block";
                    return false;
                }

                // Valida e-mail do Usuário
                var mail = document.getElementById('inpEmailUser').value;
                var er = new RegExp(/^[a-z0-9_\-\.]+@[a-z0-9_\-\.]{2,}\.[a-z0-9]{2,}(\.[a-z0-9])?/);

                if (!er.test(mail) || mail.match(" ")) {

                    document.formulario.inpEmailUser.focus();
                    document.getElementById('divErroEmailUser').style.display = "block";
                    return false;
                }
            }
            ;
            
            function limparErrosNomeUser() {

                document.getElementById('divErroNomeUser').style.display = "none";
            }
            ;

            function limparErrosEmailUser() {

                document.getElementById('divErroEmailUser').style.display = "none";
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
        <div>
            <div class="container">
                <h3>NOVO USUÁRIO</h3>
                <br>
                <form role="form" action="ServletAddUsuario" method="POST" id="formulario" name="formulario">
                    <br>
                    <div class="form-group">
                        <label for="inpNomeUser">Nome:</label>
                        <input type="text" class="form-control" onchange="return limparErrosNomeUser()" id="inpNomeUser" name="inpNomeUser" placeholder="Informe o nome do usuário" maxlength="128">
                        <span style="color: red; display: none" id="divErroNomeUser">Nome inexistente ou inválido.</span>
                    </div>
                    <div class="row form-group">
                        <div class="col-xs-6 col-sm-2">
                            <label for="opTipoUser">Tipo:</label>
                            <select class="form-control" id="opTipoUser" name="opTipoUser">
                                <option>1 - Professor</option>
                                <option>2 - Aluno</option>
                                <option>3 - Secretaria</option>
                            </select>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-xs-6 col-sm-5">
                            <label for="opDptUser">Departamento:</label>
                            <select class="form-control" id="opDptUser" name="opDptUser">
                                <option>1 - DEPARTAMENTO DE CIÊNCIA E ENGENHARIA DE MATERIAIS</option>
                                <option>2 - DEPARTAMENTO DE COMPUTAÇÃO</option>
                                <option>3 - DEPARTAMENTO DE ENGENHARIA AMBIENTAL</option>
                                <option>4 - DEPARTAMENTO DE ENGENHARIA CIVIL</option>
                                <option>5 - DEPARTAMENTO DE ENGENHARIA DE PRODUÇÃO</option>
                                <option>6 - DEPARTAMENTO DE ENGENHARIA ELÉTRICA</option>
                                <option>7 - DEPARTAMENTO DE ENGENHARIA MECÂNICA</option>
                                <option>8 - DEPARTAMENTO DE ENGENHARIA QUÍMICA</option>
                                <option>9 - DEPARTAMENTO DE ESTATÍSTICA E CIÊNCIAS ATUARIAIS</option>
                                <option>10 - DEPARTAMENTO DE FÍSICA</option>
                                <option>11 - DEPARTAMENTO DE GEOLOGIA</option>
                                <option>12 - DEPARTAMENTO DE MATEMÁTICA</option>
                                <option>13 - DEPARTAMENTO DE QUÍMICA</option>
                                <option>14 - DEPARTAMENTO DE TECNOLOGIA DE ALIMENTOS</option>
                                <option>15 - NÚCLEO DE GRADUAÇÃO EM ENGENHARIA DE PETRÓLEO</option>
                                <option>16 - DIREÇÃO DO CCET</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inpEmailUser">E-mail:</label>
                        <input type="text" class="form-control" onchange="return limparErrosEmailUser()" id="inpEmailUser" name="inpEmailUser" placeholder="Informe o e-mail do usuário" maxlength="64">
                        <span style="color: red; display: none" id="divErroEmailUser">E-mail inválido.</span>
                    </div>
                    <br>
                    <div class="form-group">
                        <div class="form-horizontal">
                            <a href="ServletFiltrarUsuarios" title=""> <button style="margin-right: 10px" type="button" class="btn btn-danger">CANCELAR</button></a>
                            <button type="submit" onclick="return validaCampos();" class="btn btn-primary">CADASTRAR</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
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