<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="MatriculaGenerica.aspx.cs" Inherits="SoftPixelPenguinsWA.MatriculaGenerica" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Proceso de Matrícula</title>
    <link rel="stylesheet" href="../Content/EstilosMatriculaG.css" />
    <script src="jquery-3.7.1.min.js"></script>
</head>
<body>
<div class="header">
    <img src="Images/PIXEL.png" alt="Logo" />
    <h1>Pixel Penguins</h1>
    <div class="nav">
        <a href="Login.aspx">Intranet</a>
        <a href="Matricularse.aspx">Matrícula</a>
    </div>
</div>
<form id="form1" runat="server">
    <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>
    <div class="container">
        <h2>Proceso de matrícula - <span id="sectionTitle" runat="server"></span></h2><hr>

        <div class="sidebar-progress">
            <div class="progress-bar">
                <span id="step1" class="step" runat="server"></span>
                <span id="step2" class="step" runat="server"></span>
                <span id="step3" class="step" runat="server"></span>
            </div>
        </div>

        <div class="main-content">
            <div id="section1" class="section" runat="server" style="display: block;">
                <div class="form-section">
                    <h3>Datos del alumno</h3>
                    <hr>
                    <div class="form-group">
                        <div class="form-row">
                            <label>Nombres:</label>
                            <asp:TextBox ID="txtNombreAlumno" runat="server" placeholder="Nombres" required="required" CssClass="form-control"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Apellido Paterno:</label>
                            <asp:TextBox ID="txtApellidoPaterno" runat="server" placeholder="Apellido Paterno" required="required" CssClass="form-control"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Apellido Materno:</label>
                            <asp:TextBox ID="txtApellidoMaterno" runat="server" placeholder="Apellido Materno" required="required" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <label>DNI:</label>
                            <asp:TextBox ID="txtDNIAlumno" runat="server" placeholder="DNI" required="required" CssClass="form-control dni-field" ClientIDMode="Static"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Fecha de Nacimiento:</label>
                            <asp:TextBox ID="dtpFechaNacimiento" runat="server" placeholder="Fecha de Nacimiento" CssClass="date-picker form-control" TextMode="Date" required="required"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label for="ddlSexo">Sexo:</label>
                            <asp:DropDownList ID="ddlSexo" runat="server" CssClass="form-control custom-dropdown" required="required">
                                <asp:ListItem Text="Seleccionar" Value="" />
                                <asp:ListItem Text="Masculino" Value="Masculino" />
                                <asp:ListItem Text="Femenino" Value="Femenino" />
                            </asp:DropDownList>
                        </div>
                        <div class="form-row">
                            <label>Email:</label>
                            <asp:TextBox ID="txtEmail" runat="server" placeholder="Email" required="required" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <label>Direccion:</label>
                            <asp:TextBox ID="txtDireccion" runat="server" placeholder="Direccion" required="required" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                </div>
                <div class="form-section">
                    <h3>Datos del Apoderado</h3>
                    <hr>
                    <div class="form-group">
                        <div class="form-row">
                            <label>DNI:</label>
                            <asp:TextBox ID="txtDNIApoderado" runat="server" placeholder="DNI" required="required" CssClass="form-control dni-field"></asp:TextBox>
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
                <p>Sus datos personales y certificados han sido enviados a revisión. Por favor, este atento a su correo electrónico para revisar el estado de su proceso de matrícula.</p>
                <asp:Button ID="btnVolver1" runat="server" Text="Volver al inicio" OnClick="btnVolver_Click" CssClass="button-style" />
            </div>
        </div>
    </div>
</form>
</body>
</html>
