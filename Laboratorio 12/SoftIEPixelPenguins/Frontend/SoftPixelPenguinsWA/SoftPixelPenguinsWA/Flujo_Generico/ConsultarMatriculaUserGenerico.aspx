<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="ConsultarMatriculaUserGenerico.aspx.cs" Inherits="SoftPixelPenguinsWA.Flujo_Generico.ConsultarMatriculaUserGenerico" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">

    <script src="jquery-3.7.1.min.js"></script>
    <script>
        $(document).ready(function () {
            // Escucha el evento submit del formulario
            $("form").on("submit", function (e) {
                let isValid = true;

                // Valida que los campos de texto no estén vacíos
                $(".validate-required").each(function () {
                    if ($(this).val().trim() === "") {
                        isValid = false;
                        $(this).addClass("is-invalid");
                    } else {
                        $(this).removeClass("is-invalid");
                    }
                });


                // Si no es válido, previene el envío del formulario
                if (!isValid) {
                    e.preventDefault();
                    alert("Por favor, completa todos los campos obligatorios.");
                }
            });
        });
    </script>
</asp:Content>

<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexUserGenerico.aspx"><i class="fa-solid fa-home"></i> Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="MatriculaOnlineUserGenerico.aspx"><i class="fa-solid fa-archive"></i> Matrícula Online</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="MiPerfilAlumno.aspx"><i class="fa-solid fa-user"></i> Mi Perfil</a>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">

    <link rel="stylesheet" href="../Content/EstilosMatriculaG.css" />


    <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>

    <div class="container">

        <h2>Proceso de matrícula - <span id="sectionTitle" runat="server"></span></h2><hr>

        <div class="sidebar-progress">
            <div class="progress-bar">
                <span id="step1" class="step" runat="server"></span>
                <span id="step2" class="step" runat="server"></span>
                <span id="step3" class="step" runat="server"></span>
                <span id="step4" class="step" runat="server"></span>
                <span id="step5" class="step" runat="server"></span>
                <span id="step6" class="step" runat="server"></span>
            </div>
        </div>


        <div class="main-content">
            <div id="section1" class="section" runat="server" style="display: block;">
                <div class="form-section">
                    <h3>Datos del Apoderado</h3>
                    <hr>
                    <div class="form-group">
                        <div class="form-row">
                            <label>DNI:</label>
                            <asp:TextBox ID="txtDNIApoderado" runat="server" placeholder="DNI" required="required" CssClass="form-control"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Nombre Completo:</label>
                            <asp:TextBox ID="txtNombreApoderado" runat="server" placeholder="Nombre completo" required="required" CssClass="form-control"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Teléfono:</label>
                            <asp:TextBox ID="txtTelefonoApoderado" runat="server" placeholder="Teléfono" required="required" CssClass="form-control"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Relación:</label>
                            <asp:DropDownList ID="ddlRelacionApoderado" runat="server" CssClass="form-control custom-dropdown" required="required">
                            <asp:ListItem Text="Seleccionar" Value="" />
                            <asp:ListItem Text="Padre" Value="Padre" />
                            <asp:ListItem Text="Madre" Value="Madre" />
                        </asp:DropDownList>
                        </div>
                    </div>
                </div>
                <div class="button-group">
                    <asp:Button ID="btnRegresar1" runat="server" Text="Regresar" OnClick="prevSection" CssClass="button-style" />
                    <asp:Button ID="btnGrabar1" runat="server" Text="Grabar y Continuar" OnClick="nextSection" CssClass="button-style" />
                </div>
            </div>
            <div id="section2" class="section" runat="server" style="display: none;">
                <div class="form-section">
                    <h3>Seleccionar Grado Académico</h3><hr>
                    <div class="form-row">
                        <label for="ddlGrados">Por favor seleccione el grado en el que desea matricularse:</label>
                        <asp:DropDownList ID="ddlGrados" runat="server" CssClass="dll">
                        </asp:DropDownList>
                    </div>
                </div>
                <div class="form-section">
                    <h3>Adjuntar Certificados</h3><hr>
                    <div class="form-group">
                        <div class="form-row">
                            <label for="fileCertificadoEstudios">Certificado de Estudios:</label>
                            <asp:FileUpload ID="fileCertificadoEstudios" runat="server" CssClass="file-upload" />
                        </div>
                     </div>
                    <div class="form-group">
                        <div class="form-row">
                            <label for="fileCertificadoSalud">Certificado de Salud:</label>
                            <asp:FileUpload ID="fileCertificadoSalud" runat="server" CssClass="file-upload" />
                        </div>
                    </div>
                </div>
                <div class="button-group">
                    <asp:Button ID="btnRegresar2" runat="server" Text="Regresar" OnClick="prevSection" CssClass="button-style" />
                    <asp:Button ID="btnGuardar" runat="server" Text="Grabar y Continuar" OnClick="btnGuardar_Click" CssClass="button-style" />
                </div>
            </div>

            <div id="section3" class="section" runat="server" style="display: none;">
                <p>Sus datos personales y certificados han sido enviados a revisión. En un periodo de 24 horas podrá ver, por este medio, el estado de su proceso de matrícula.</p>
                <asp:Button ID="btnVolver1" runat="server" Text="Volver al inicio" OnClick="btnVolver_Click" CssClass="button-style" />
                
            </div>

            <div id="section4" class="section" runat="server" style="display: none;">
                <div class="form-section">
                    <h3>Adjuntar Boucher de Pago</h3><hr>
                    <p style="text-align:center;">Debe realizar el pago correspondiente de la matrícula para continuar con el proceso de matrícula.</p>
                    <div class="form-info">
                        <p style="color: whitesmoke">Cuenta Bancaria a depositar XXXX-XXXX-XXXXXXXXXX</p>
                    </div>
                    <div class="form-row" style="margin:20px;">
                        <label for="fileBoucherPago">Adjuntar Boucher de Pago::</label>
                        <asp:FileUpload ID="fileBoucherPago" runat="server" CssClass="file-upload" />
                        <div class="button-group">
                            <asp:Button ID="btnRegresar3" runat="server" Text="Regresar" OnClick="prevSection" CssClass="button-style" />
                            <asp:Button ID="btnGuardar2" runat="server" Text="Grabar y Continuar" OnClick="btnGuardarBoucher_Click" CssClass="button-style" />
                        </div>
                    </div>
                </div>
            </div>

            <div id="section5" class="section" runat="server" style="display: none;">
                <p>Su boucher de pago ha sido enviado a revisión. En un periodo de 24 horas podrá ver, por este medio, el estado de su proceso de matrícula.</p>
                <asp:Button ID="btnVolver2" runat="server" Text="Volver al inicio" OnClick="btnVolver_Click" CssClass="button-style" />
                 
            </div>

            <div id="section6" class="section" runat="server" style="display: none;">
                <p>Gracias por concluir con los pasos correspondientes para el proceso de matrícula. Usted ha sido matriculado en el periodo 2025 con éxito. En enviará un correo con toda la información de su matrícula.</p>
                <asp:Button ID="Button1" runat="server" Text="Terminar proceso de matrícula" OnClick="btnVolver_Click" CssClass="button-style" />
            </div>
        </div>

    </div>
</asp:Content>
