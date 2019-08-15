<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>

<%
    Calendar dataDiaSeguinte = Calendar.getInstance();
    dataDiaSeguinte.add(Calendar.DAY_OF_WEEK, +1);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String dataMinima = simpleDateFormat.format(dataDiaSeguinte.getTime());
    
    SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("dd/MM/yyyy");
    String dataMinima2 = simpleDateFormat4.format(dataDiaSeguinte.getTime());

    SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("dd/MM/yyyy");
    String dataMinima3 = simpleDateFormat3.format(dataDiaSeguinte.getTime());

    Calendar dataMaximaEvt = Calendar.getInstance();
    dataMaximaEvt.add(Calendar.MONTH, 5);
    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
    String dataMaxima = simpleDateFormat2.format(dataMaximaEvt.getTime());
    
    SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat("dd/MM/yyyy");
    String dataMaxima2 = simpleDateFormat5.format(dataMaximaEvt.getTime());
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
                    } else
                        localStorage.removeItem( 'firstLoad' );
                }
            })();

            function validaCampos() {
                
                // Valida o nome do Evento --------------------------------------------------
                var nomeEvento = document.getElementById('inpNomeEvento').value;

                while (nomeEvento.indexOf(" ") !== -1) {

                    nomeEvento = nomeEvento.replace(" ", "");
                }

                if (nomeEvento.length < 8) {

                    document.formulario.inpNomeEvento.focus();
                    document.getElementById('divErroNomeEvento').style.display = "block";
                    return false;
                }


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

                if (data < '<%=dataMinima%>') {

                    document.formulario.inpDataEvento.focus();
                    document.getElementById('divErroData2').style.display = "block";
                    return false;
                }

                if (data > '<%=dataMaxima%>') {

                    document.formulario.inpDataEvento.focus();
                    document.getElementById('divErroData3').style.display = "block";
                    return false;
                }


                // Validar hora --------------------------------------------------
                var horaInicio = document.getElementById('inpInicioEvento').value;
                var duracao = document.getElementById('duracao').value;

                var horaInicioHoras = horaInicio.substr(0, 2);
                var inicioHorasEmMinutos = parseInt(horaInicioHoras) * 60;
                var horaInicioMinutos = horaInicio.substr(3, horaInicio.length);
                var inicioMinutosTotal = inicioHorasEmMinutos + parseInt(horaInicioMinutos);

                if (horaInicioHoras == "" | horaInicioMinutos == "") {

                    document.formulario.inpInicioEvento.focus();
                    document.getElementById('divErroHoraInicio').style.display = "block";
                    return false;
                }

                if (inicioMinutosTotal < 420 | inicioMinutosTotal > 1350) {

                    document.formulario.inpInicioEvento.focus();
                    document.getElementById('divErroHoraInicioMin').style.display = "block";
                    return false;
                }

                var duracaoHoras = duracao.substr(0, 2);
                var duracaoMinutos = parseInt(duracaoHoras) * 60;
                var duracaoEmMinutos = duracao.substr(3, duracao.length);
                var duracaoTotal = duracaoMinutos + parseInt(duracaoEmMinutos);

                if (duracaoHoras == "" | duracaoEmMinutos == "") {

                    document.formulario.duracao.focus();
                    document.getElementById('divErroNomeDuracao').style.display = "block";
                    return false;
                }

                if (duracaoTotal < 30) {

                    document.formulario.duracao.focus();
                    document.getElementById('divErroDuracaoMinima').style.display = "block";
                    return false;
                }

                var fimEvento = parseInt(duracaoTotal) + parseInt(inicioMinutosTotal);

                if (fimEvento > 1380) {

                    document.formulario.duracao.focus();
                    document.getElementById('divErroDuracaoMaxima').style.display = "block";
                    return false;
                }


                // Valida Local --------------------------------------------------
                var local = document.getElementById('inpLocalEvento').value;

                while (local.indexOf(" ") !== -1) {

                    local = local.replace(" ", "");
                }

                if (local.length < 15) {

                    document.formulario.inpLocalEvento.focus();
                    document.getElementById('divErroLocal').style.display = "block";
                    return false;
                }


                // Valida o nome do Organizador --------------------------------------------------
                var nomeOrganizador = document.getElementById('inpRespEvento').value;

                while (nomeOrganizador.indexOf(" ") !== -1) {

                    nomeOrganizador = nomeOrganizador.replace(" ", "");
                }

                if (nomeOrganizador.length < 10) {

                    document.formulario.inpRespEvento.focus();
                    document.getElementById('divErroNomeOrganizador').style.display = "block";
                    return false;
                }


                // Valida e-mail do organizador
                var mail = document.getElementById('inpEmailOrganizador').value;
                var er = new RegExp(/^[a-z0-9_\-\.]+@[a-z0-9_\-\.]{2,}\.[a-z0-9]{2,}(\.[a-z0-9])?/);

                if (!er.test(mail) || mail.match(" ")) {

                    document.formulario.inpEmailOrganizador.focus();
                    document.getElementById('divErroEmailOrganizador').style.display = "block";
                    return false;
                }
                
                // Valida a descrição do Evento --------------------------------------------------
                var descricaoEvento = document.getElementById('inpResumoEvento').value;

                while (descricaoEvento.indexOf(" ") !== -1) {

                    descricaoEvento = descricaoEvento.replace(" ", "");
                }

                if (descricaoEvento.length < 8) {

                    document.formulario.inpResumoEvento.focus();
                    document.getElementById('divErroDescricao').style.display = "block";
                    return false;
                }
            }
            ;
            

            function limparErrosHora() {

                document.getElementById('divErroHoraInicio').style.display = "none";
                document.getElementById('divErroHoraInicioMin').style.display = "none";
                document.getElementById('divErroNomeDuracao').style.display = "none";
                document.getElementById('divErroDuracaoMaxima').style.display = "none";
                document.getElementById('divErroDuracaoMinima').style.display = "none";
            }
            ;

            function limparErrosNomeEvento() {

                document.getElementById('divErroNomeEvento').style.display = "none";
            }
            ;

            function limparErrosData() {

                document.getElementById('divErroData').style.display = "none";
                document.getElementById('divErroData2').style.display = "none";
                document.getElementById('divErroData3').style.display = "none";
            }
            ;

            function limparErrosLocal() {

                document.getElementById('divErroLocal').style.display = "none";
            }
            ;

            function limparErrosNomeOrganizador() {

                document.getElementById('divErroNomeOrganizador').style.display = "none";
            }
            ;

            function limparErrosEmailOrganizador() {

                document.getElementById('divErroEmailOrganizador').style.display = "none";
            }
            ;
            
            function limparErrosDescricao() {

                document.getElementById('divErroDescricao').style.display = "none";
            }
            ;
        </script>
        
        <style>
            input[type='file'] {
              display: none
            }
        </style>

        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <jsp:include page = "menu_superior.jsp" />
        <div>
            <div class="container">
                <h3>NOVO EVENTO</h3>
                <br>
                <form enctype="multipart/form-data" method="POST" action="AddEvento" id="formulario" name="formulario" onsubmit="alert('Evento cadastrado com sucesso! Aguarde confirmação do CCET via e-mail!');">
                <!--<form method="POST" action="AddEvento" id="formulario" name="formulario">-->
                    <label id="labelUpload" name="labelUpload" for="inpUpload">Escolha um imagem (.png ou .jpg) para o folder do seu evento:</label>
                    <br>
                    <div class="row form-group">
                        <div id="wrapper">
                            <div class="col-xs-6 col-sm-5">
                                <label class="btn btn-info" id="labelUploadInput" name="labelUploadInput" for='inpUpload'>Clique para escolher uma imagem</label>
                                <input type="file" id="inpUpload" name="inpUpload" accept="image/png, image/jpeg"/>
                            </div>
                            <div class="col-xs-6 col-sm-5">
                                <a id="aHrefImage" target="_blank">
                                    <div id="image-holder"></div>
                                </a>
                            </div>
                        </div>
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="inpNomeEvento">Nome do Evento:</label>
                        <!--<input type="text" class="form-control" onchange="return limparErrosNomeEvento()" id="inpNomeEvento" value="Guia de Sobrevivência do desenvolvedor Full Stack" name="inpNomeEvento" placeholder="Informe o nome do evento" maxlength="256">-->
                        <input type="text" class="form-control" onchange="return limparErrosNomeEvento()" id="inpNomeEvento" name="inpNomeEvento" placeholder="Informe o nome do evento" maxlength="256">
                        <span style="color: red; display: none" id="divErroNomeEvento">Nome inexistente ou inválido.</span>
                    </div>
                    <div class="row form-group">
                        <div class="col-xs-6 col-sm-4">
                            <label for="opTipoEvento">Tipo do Evento:</label>
                            <select class="form-control" id="opTipoEvento" name="opTipoEvento">
                                <option>1 - Palestra</option>
                                <option>2 - Seminário</option>
                                <option>3 - Congresso</option>
                                <option>4 - Simpósio</option>
                                <option>5 - Minicurso</option>
                                <option>6 - Apresentação de Projeto ou Estágio</option>
                                <option>7 - Apresentação de TCC</option>
                                <option>8 - Defesa de Mestrado</option>
                                <option>9 - Defesa de Doutorado</option>
                                <option>10 - Outro</option>
                            </select>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-xs-6 col-sm-4">
                            <label for="inpDataEvento">Data do Evento (entre <%=dataMinima2%> e <%=dataMaxima2%>):</label>
                            <!--<input type="date" class="form-control"onchange="return limparErrosData()" id="inpDataEvento" name="inpDataEvento" min="<%=dataMinima%>" max="<%=dataMaxima%>" value="<%=dataMinima%>" required="">-->
                            <!--<input type="date" class="form-control" onchange="return limparErrosData()" value="<%=dataMinima%>" min="<%=dataMinima%>" max="<%=dataMaxima%>" id="inpDataEvento" name="inpDataEvento">-->
                            <input type="date" class="form-control" onchange="return limparErrosData()" min="<%=dataMinima%>" max="<%=dataMaxima%>" id="inpDataEvento" name="inpDataEvento">
                            <span style="color: red; display: none" id="divErroData">Preencha a data completa.</span>
                            <span style="color: red; display: none" id="divErroData2">A data precisa ser a partir de <%=dataMinima3%>, porque precisamos de 1 (dia) para a divulgação do seu evento.</span>
                            <span style="color: red; display: none" id="divErroData3">Data muito distante.</span>
                        </div>
                        <div class="col-xs-6 col-sm-4">
                            <label for="inpInicioEvento">Horário de Início:</label>
                            <!--<input type="time" class="form-control" onchange="return limparErrosHora()" id="inpInicioEvento" value="07:00" min="07:00" max="20:30" id="inpInicioEvento" name="inpInicioEvento">-->
                            <!--<input type="time" class="form-control" onchange="return limparErrosHora()" id="inpInicioEvento" value="07:00" name="inpInicioEvento">-->
                            <input type="time" class="form-control" onchange="return limparErrosHora()" id="inpInicioEvento" name="inpInicioEvento">
                            <span style="color: red; display: none" id="divErroHoraInicio">Informe a hora completa.</span>
                            <span style="color: red; display: none" id="divErroHoraInicioMin">O evento só poderá iniciar entre 07:00 e 22:30.</span>
                        </div>
                        <div class="col-xs-6 col-sm-4">
                            <label for="duracao">Duração prevista. Ex: 02:30 (duas horas e trinta minutos)</label>
                            <!--<input type="time" class="form-control" onchange="return limparErrosHora()" id="inpFimEvento" value="07:30" min="07:30" max="21:00" id="inpFimEvento" name="inpFimEvento">-->
                            <!--<input type="time" class="form-control" onchange="return limparErrosHora()" id="duracao" value="02:30" name="duracao">-->
                            <input type="time" class="form-control" onchange="return limparErrosHora()" id="duracao" name="duracao">
                            <span style="color: red; display: none" id="divErroNomeDuracao">Informe a duração completa.</span>
                            <span style="color: red; display: none" id="divErroDuracaoMaxima">O evento só poderá durar até às 23:00.</span>
                            <span style="color: red; display: none" id="divErroDuracaoMinima">O evento precisa ter no mínimo 30 minutos de duração.</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inpLocalEvento">Local do Evento:</label>
                        <!--<input type="text" class="form-control" onchange="return limparErrosLocal()" id="inpLocalEvento" value="SALA DE SEMINÁRIOS-DMA" name="inpLocalEvento" placeholder="Informe o local do evento" maxlength="256">-->
                        <input type="text" class="form-control" onchange="return limparErrosLocal()" id="inpLocalEvento" name="inpLocalEvento" placeholder="Informe o local do evento" maxlength="256">
                        <span style="color: red; display: none" id="divErroLocal">Nome de local inexistente ou inválido.</span>
                    </div>
                    <div class="form-group">
                        <label for="inpRespEvento">Nome do(a) organizador(a) do Evento:</label>
                        <!--<input type="text" class="form-control" onchange="return limparErrosNomeOrganizador()" id="inpRespEvento" value="Prof. Dr. Hendrik Macedo" name="inpRespEvento" placeholder="Informe o(a) responsável pelo evento" maxlength="128">-->
                        <input type="text" class="form-control" onchange="return limparErrosNomeOrganizador()" id="inpRespEvento" name="inpRespEvento" placeholder="Informe o(a) responsável pelo evento" maxlength="128">
                        <span style="color: red; display: none" id="divErroNomeOrganizador">Nome inexistente ou inválido.</span>
                    </div>
                    <div class="form-group">
                        <label for="inpEmailOrganizador">E-mail do(a) organizador(a) do Evento:</label>
                        <!--<input type="text" class="form-control" onchange="return limparErrosEmailOrganizador()" id="inpEmailOrganizador" value="fulano@gmail.com" name="inpEmailOrganizador" placeholder="Informe o e-mail do(a) responsável pelo evento" maxlength="64">-->
                        <input type="text" class="form-control" onchange="return limparErrosEmailOrganizador()" id="inpEmailOrganizador" name="inpEmailOrganizador" placeholder="Informe o e-mail do(a) responsável pelo evento" maxlength="64">
                        <span style="color: red; display: none" id="divErroEmailOrganizador">E-mail inexistente ou inválido.</span>
                    </div>
                    <div class="form-group">
                        <label for="inpResumoEvento">Descrição do Evento:</label>
                        <textarea maxlength="5000" onchange="return limparErrosDescricao()" style="resize: none" class="form-control" id="inpResumoEvento" name="inpResumoEvento" rows="7" placeholder="Escreva um breve resumo sobre o evento, como a descrição, programação, etc."></textarea>
                        <span style="color: red; display: none" id="divErroDescricao">Descrição inexistente ou inválida.</span>
                    </div>
                    <div class="form-group">
                        <div class="form-horizontal">
                            <a href="index.jsp" title=""> <button style="margin-right: 10px" type="button" class="btn btn-danger">CANCELAR</button></a>
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

            $("#inpUpload").on('change', function () {

                if (typeof (FileReader) != "undefined") {

                    var image_holder = $("#image-holder");
                    image_holder.empty();

                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $("<img />", {
                            "src": e.target.result,
                            "class": "thumb-image",
                            "style": "border: 2px solid #ccc; width: 300px; height: 280px;"
                        }).appendTo(image_holder);
                    }
                    image_holder.show();
                    reader.readAsDataURL($(this)[0].files[0]);
                } else{
                    alert("Este navegador nao suporta FileReader.");
                }
            });
        </script>
    </body>
</html>