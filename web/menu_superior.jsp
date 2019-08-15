<%@page import="Model.Evento"%>
<%@page import="java.util.List"%>
<%@page import="Model.Usuario"%>
<!DOCTYPE html>
<%
    Usuario usuario = (Usuario) session.getAttribute("user");

    int tipoAcesso = 0;

    if (session.getAttribute("user") == null) {

        tipoAcesso = 0; // Não tem ninguém logado
    } else {

        switch (usuario.getTipoUsuario()) {
            case 0:
                tipoAcesso = 1; // ADM logado
                break;
            case 1:
                tipoAcesso = 2; // Colaborador logado
                break;
        }
    }
%>

<script type="text/javascript">

    function confirmValidar() {

        if (!confirm("Você irá enviar e-mails de divulgação dos eventos para todos os usuários cadastrados neste sistema. Tem certeza que deseja divulgar?")) {

            return false;
        }
    }
    ;
</script>

<nav class="navbar navbar-default">
    <div class="container">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-navbar-collapse">
            <span class="sr-only">Toggle Navigation</span>
            <i class="fa fa-bars"></i>
        </button>
        <a href="index.jsp" class="navbar-brand">
            <h1 title="Ir para a página inicial">CCET - UFS</h1>
        </a>
        <div class="collapse navbar-collapse" id="bs-navbar-collapse">
            <ul class="nav navbar-nav main-navbar-nav">
                <li class="dropdown">
                    <%
                        if (tipoAcesso == 0) {
                    %>
                    <li><a style="font-weight: bold; color: #3f71a2" href="ServletFiltrarEventosDptConfirmados?dptConfirm=0" title="">EVENTOS</a></li>
                    <%
                        }
                    %>
                    
                    <%
                        if (tipoAcesso == 2) {
                    %>
                    <a style="font-weight: bold; color: #3f71a2" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">EVENTOS <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=0" title="">VER EVENTOS</a></li>
                        <li><a href="add_evento.jsp" title="">CADASTRAR EVENTO</a></li>
                    </ul>
                    <%
                        }
                    %>
                    
                    <%
                        if (tipoAcesso == 1) {
                    %>
                    <a style="font-weight: bold; color: #3f71a2" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">EVENTOS <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="ServletFiltrarEventosDptConfirmados?dptConfirm=0" title="">VER EVENTOS</a></li>
                        <li><a href="ServletFiltrarEventosDpt?dpt=0" title="">GERENCIAR EVENTOS</a></li>
                        <li><a onclick="return confirmValidar();" href="ServletDivulgarEvts" title="">DIVULGAR EVENTOS</a></li>
                    </ul>
                    <%
                        }
                    %>
                </li>
                <li class="dropdown">
                    <a title="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">PÓS-GRADUAÇÃO <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a target="_blank" href="http://www.posgraduacao.ufs.br/profmat" title="">PROGRAMA DE MESTRADO PROFISSIONAL EM MATEMÁTICA - MESTRADO PROFISSIONAL (PROFMAT)</a></li>
                        <li><a target="_blank" href="http://www.posgraduacao.ufs.br/procc" title="">PROGRAMA DE PÓS-GRADUAÇÃO EM CIÊNCIA DA COMPUTAÇÃO - MESTRADO (PROCC)</a></li>
                        <li><a target="_blank" href="http://www.posgraduacao.ufs.br/ppgci" title="">PROGRAMA DE PÓS-GRADUAÇÃO EM CIÊNCIA DA INFORMAÇÃO - MESTRADO (PPGCI)</a></li>
                        <li><a target="_blank" href="http://www.posgarduacao.ufs.br/p2cem" title="">PROGRAMA DE PÓS-GRADUAÇÃO EM CIÊNCIA E ENGENHARIA DE MATERIAIS - MESTRADO E DOUTORADO (P2CEM)</a></li>
                        <li><a target="_blank" href="http://www.posgraduacao.ufs.br/procta" title="">PROGRAMA DE PÓS-GRADUAÇÃO EM CIÊNCIA E TECNOLOGIA DE ALIMENTOS - MESTRADO (PROCTA)</a></li>
                        <li><a target="_blank" href="http://www.posgraduacao.ufs.br/proec" title="">PROGRAMA DE PÓS-GRADUAÇÃO EM ENGENHARIA CIVIL - MESTRADO (PROEC)</a></li>
                        <li><a target="_blank" href="http://www.posgraduacao.ufs.br/ppgecia" title="">PROGRAMA DE PÓS-GRADUAÇÃO EM ENGENHARIA E CIÊNCIAS AMBIENTAIS - MESTRADO (PPGECIA)</a></li>
                        <li><a target="_blank" href="http://www.posgraduacao.ufs.br/proee" title="">PROGRAMA DE PÓS-GRADUAÇÃO EM ELÉTRICA - MESTRADO (PROEE)</a></li>
                        <li><a target="_blank" href="http://www.posgraduacao.ufs.br/peq" title="">PROGRAMA DE PÓS-GRADUAÇÃO EM ENGENHARIA QUÍMICA - MESTRADO (PEQ)</a></li>
                        <li><a target="_blank" href="http://www.posgraduacao.ufs.br/npgecima" title="">PROGRAMA DE PÓS-GRADUAÇÃO EM ENSINO DE CIÊNCIA E MATEMÁTICA - MESTRADO (NPGECIMA)</a></li>
                        <li><a target="_blank" href="http://www.posgraduacao.ufs.br/npgfi" title="">PROGRAMA DE PÓS-GRADUAÇÃO EM FÍSICA - MESTRADO E DOUTORADO (NPGFI)</a></li>
                        <li><a target="_blank" href="http://www.posgraduacao.ufs.br/promat" title="">PROGRAMA DE PÓS-GRADUAÇÃO EM MATEMÁTICA - MESTRADO (PROMAT)</a></li>
                        <li><a target="_blank" href="http://www.posgraduacao.ufs.br/ppgq" title="">PROGRAMA DE PÓS-GRADUAÇÃO EM QUÍMICA - MESTRADO E DOUTORADO (PPGQ)</a></li>
                        <li><a target="_blank" href="http://www.posgraduacao.ufs.br/ppgpf" title="">PROGRAMA DE PÓS-GRADUAÇÃO PROFISSIONAL EM ENSINO DE FÍSICA - METRADO PROFISSIONAL (PPGPF)</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a title="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">DEPARTAMENTOS <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a target="_blank" href="https://www.sigaa.ufs.br/sigaa/public/departamento/portal.jsf?id=205" title="">DEPARTAMENTO DE CIÊNCIA E ENGENHARIA DE MATERIAIS</a></li>
                        <li><a target="_blank" href="https://www.sigaa.ufs.br/sigaa/public/departamento/portal.jsf?lc=pt_BR&id=83" title="">DEPARTAMENTO DE COMPUTAÇÃO</a></li>
                        <li><a target="_blank" href="https://www.sigaa.ufs.br/sigaa/public/departamento/portal.jsf?lc=pt_BR&id=607" title="">DEPARTAMENTO DE ENGENHARIA AMBIENTAL</a></li>
                        <li><a target="_blank" href="https://www.sigaa.ufs.br/sigaa/public/departamento/portal.jsf?lc=pt_BR&id=81" title="">DEPARTAMENTO DE ENGENHARIA CIVIL</a></li>
                        <li><a target="_blank" href="https://www.sigaa.ufs.br/sigaa/public/departamento/portal.jsf?lc=pt_BR&id=214" title="">DEPARTAMENTO DE ENGENHARIA DE PRODUÇÃO</a></li>
                        <li><a target="_blank" href="https://www.sigaa.ufs.br/sigaa/public/departamento/portal.jsf?lc=pt_BR&id=199" title="">DEPARTAMENTO DE ENGENHARIA ELÉTRICA</a></li>
                        <li><a target="_blank" href="https://www.sigaa.ufs.br/sigaa/public/departamento/portal.jsf?lc=pt_BR&id=207" title="">DEPARTAMENTO DE ENGENHARIA MECÂNICA</a></li>
                        <li><a target="_blank" href="https://www.sigaa.ufs.br/sigaa/public/departamento/portal.jsf?lc=pt_BR&id=82" title="">DEPARTAMENTO DE ENGENHARIA QUÍMICA</a></li>
                        <li><a target="_blank" href="https://www.sigaa.ufs.br/sigaa/public/departamento/portal.jsf?lc=pt_BR&id=200" title="">DEPARTAMENTO DE ESTATÍSTICA E CIÊNCIAS ATUARIAIS</a></li>
                        <li><a target="_blank" href="https://www.sigaa.ufs.br/sigaa/public/departamento/portal.jsf?lc=pt_BR&id=84" title="">DEPARTAMENTO DE FÍSICA</a></li>
                        <li><a target="_blank" href="https://www.sigaa.ufs.br/sigaa/public/departamento/portal.jsf?lc=pt_BR&id=204" title="">DEPARTAMENTO DE GEOLOGIA</a></li>
                        <li><a target="_blank" href="https://www.sigaa.ufs.br/sigaa/public/departamento/portal.jsf?lc=pt_BR&id=85" title="">DEPARTAMENTO DE MATEMÁTICA</a></li>
                        <li><a target="_blank" href="https://www.sigaa.ufs.br/sigaa/public/departamento/portal.jsf?lc=pt_BR&id=86" title="">DEPARTAMENTO DE QUÍMICA</a></li>
                        <li><a target="_blank" href="https://www.sigaa.ufs.br/sigaa/public/departamento/portal.jsf?lc=pt_BR&id=206" title="">DEPARTAMENTO DE TECNOLOGIA DE ALIMENTOS</a></li>
                        <li><a target="_blank" href="https://www.sigaa.ufs.br/sigaa/public/departamento/portal.jsf?lc=pt_BR&id=833" title="">NÚCLEO DE GRADUAÇÃO EM ENGENHARIA DE PETRÓLEO</a></li>
                    </ul>
                </li>
                <li><a target="_blank" href="https://www.sigaa.ufs.br/sigaa/public/centro/lista_cursos.jsf?lc=pt_BR&id=80" title="Link externo para o site do SIGAA">GRADUAÇÃO</a></li>
                <li><a href="apresentacao.jsp" title="Informações sobre o CCET">SOBRE O CCET</a></li>
                <%
                    if (tipoAcesso == 1) {
                %>
                <li><a href="ServletFiltrarUsuarios" title="Gerenciar usuários">USUÁRIOS</a></li>
                <%
                    }
                %>
                <li class="dropdown">
                    <%
                        if (tipoAcesso == 0) {
                    %>
                    <a data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">ACESSO</a>
                    <ul class="dropdown-menu">
                        <li><a href="login.jsp" title="">CCET EVENTOS</a></li>
                        <li><a target="_blank" href="http://www.ccetnews.ufs.br/admin" title="">ADMIN CCET</a></li>
                    </ul>
                    <%
                        }
                    %>

                    <%
                        if (tipoAcesso == 1) {
                    %>
                    <a style="color: blue;" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">ACESSO</a>
                    <ul class="dropdown-menu">
                        <li><a href="trocar_senha.jsp" title="">TROCAR SENHA</a></li>
                        <li><a href="logout.jsp" title="">SAIR</a></li>
                    </ul>
                    <%
                        }
                    %>

                    <%
                        if (tipoAcesso == 2) {
                    %>
                    <a style="color: blue;" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">ACESSO</a>
                    <ul class="dropdown-menu">
                        <li><a href="trocar_senha.jsp" title="">TROCAR SENHA</a></li>
                        <li><a href="logout.jsp" title="">SAIR</a></li>
                    </ul>
                    <%
                        }
                    %>
                </li>
            </ul>
        </div>
    </div>
</nav>