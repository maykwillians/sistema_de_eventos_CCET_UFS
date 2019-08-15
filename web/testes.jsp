<!DOCTYPE html>
<html lang="en">
    <body>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>

        <!--<button id="btn" onclick="confirmar();">Clica</button>-->

        <!--<div id="dialog-confirm" title="Executar função?"></div>-->
        <!--        <script type="text/javascript">
                    
                    function confirmar() {
                        $( "#dialog-confirm" ).dialog({
                        resizable: false,
                        height: "auto",
                        width: 400,
                            modal: true,
                            buttons: {
                                "Yap executa função b": function () {
                                    $(this).dialog("close");
                                    funcao_b();
                                },
                                'Não executa nada': function () {
                                    $(this).dialog("close");
                                    console.log('cancelado');
                                }
                            }
                        });
                    }
                    
                    function funcao_b() {
                        alert('funcao B');
                    }
                </script>-->

        <form action="ServletTestUpload" enctype="multipart/form-data" method="post">

            <label for="arquivo">Arquivo:</label>

            <input type="file" accept="image/png, image/jpeg" name="arquivo" id="arquivo"><br/>

                <label for="texto">Descrição:</label>

                <input type="text" name="texto" id="texto"><br/>
                
                <a href="ServletTestUpload?rock=mxx" title=""> <button type="button" class="btn btn-danger">CANCELAR</button></a>

                <label for="opTipoEvento">Tipo:</label>
                <select class="form-control" id="opTipoEvento" name="opTipoEvento">
                    <option>1 - Palestra</option>
                    <option>2 - Seminário</option>
                    <option>3 - Congresso</option>
                    <option>4 - Simpósio</option>
                    <option>5 - Minicurso</option>
                    <option>6 - Outro</option>
                </select>
                

                <label for="inpResumoEvento">Resumo:</label>
                <textarea maxlength="5000" style="resize: none" class="form-control" id="inpResumoEvento" name="inpResumoEvento" required="" rows="7" placeholder="Escreva um breve resumo sobre o evento"></textarea>

            <input type="submit" value="Enviar"/>

        </form>
    </body>
</html>