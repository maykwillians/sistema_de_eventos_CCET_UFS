
<!DOCTYPE html>
<%
    String erro = "";
    String str = "";
    if (session.getAttribute("msgErroEmailUser") != null) {

        str = session.getAttribute("msgErroEmailUser").toString();

        if (str.equals("1")) {

            erro = "Usu�rio cadastrado com sucesso!";
        }

        if (str.equals("0")) {

            erro = "Erro: este usu�rio j� est� cadastrado.";
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
                        
                        // L�gica de alert pr�prio da p�gina
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
                
                // Valida o nome do Usu�rio --------------------------------------------------
                var nomeUser = document.getElementById('inpNomeUser').value;

                while (nomeUser.indexOf(" ") !== -1) {

                    nomeUser = nomeUser.replace(" ", "");
                }

                if (nomeUser.length < 8) {

                    document.formulario.inpNomeUser.focus();
                    document.getElementById('divErroNomeUser').style.display = "block";
                    return false;
                }

                // Valida e-mail do Usu�rio
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
                <h3>NOVO USU�RIO</h3>
                <br>
                <form role="form" action="ServletAddUsuario" method="POST" id="formulario" name="formulario">
                    <br>
                    <div class="form-group">
                        <label for="inpNomeUser">Nome:</label>
                        <input type="text" class="form-control" onchange="return limparErrosNomeUser()" id="inpNomeUser" name="inpNomeUser" placeholder="Informe o nome do usu�rio" maxlength="128">
                        <span style="color: red; display: none" id="divErroNomeUser">Nome inexistente ou inv�lido.</span>
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
                                <option>1 - DEPARTAMENTO DE CI�NCIA E ENGENHARIA DE MATERIAIS</option>
                                <option>2 - DEPARTAMENTO DE COMPUTA��O</option>
                                <option>3 - DEPARTAMENTO DE ENGENHARIA AMBIENTAL</option>
                                <option>4 - DEPARTAMENTO DE ENGENHARIA CIVIL</option>
                                <option>5 - DEPARTAMENTO DE ENGENHARIA DE PRODU��O</option>
                                <option>6 - DEPARTAMENTO DE ENGENHARIA EL�TRICA</option>
                                <option>7 - DEPARTAMENTO DE ENGENHARIA MEC�NICA</option>
                                <option>8 - DEPARTAMENTO DE ENGENHARIA QU�MICA</option>
                                <option>9 - DEPARTAMENTO DE ESTAT�STICA E CI�NCIAS ATUARIAIS</option>
                                <option>10 - DEPARTAMENTO DE F�SICA</option>
                                <option>11 - DEPARTAMENTO DE GEOLOGIA</option>
                                <option>12 - DEPARTAMENTO DE MATEM�TICA</option>
                                <option>13 - DEPARTAMENTO DE QU�MICA</option>
                                <option>14 - DEPARTAMENTO DE TECNOLOGIA DE ALIMENTOS</option>
                                <option>15 - N�CLEO DE GRADUA��O EM ENGENHARIA DE PETR�LEO</option>
                                <option>16 - DIRE��O DO CCET</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inpEmailUser">E-mail:</label>
                        <input type="text" class="form-control" onchange="return limparErrosEmailUser()" id="inpEmailUser" name="inpEmailUser" placeholder="Informe o e-mail do usu�rio" maxlength="64">
                        <span style="color: red; display: none" id="divErroEmailUser">E-mail inv�lido.</span>
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