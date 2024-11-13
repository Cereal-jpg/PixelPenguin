<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="Matricula Online.aspx.cs" Inherits="SoftPixelPenguinsWA.Online" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Matrícula - Alumno
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link rel="stylesheet" href="../Content/EstilosMatriculaG.css" />
</asp:Content>

<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexAlumno.aspx"><i class="fa-solid fa-home"></i> Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="MisCursosAlumno.aspx"><i class="fa-solid fa-book"></i> Mis cursos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="ReporteNotasAlumno.aspx"><i class="fa-solid fa-bar-chart"></i> Reporte de Notas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="MatriculaOnlineAlumno.aspx"><i class="fa-solid fa-archive"></i> Matrícula Online</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="MisPagosAlumno.aspx"><i class="fa-solid fa-book"></i> Mis Pagos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="MiPerfilAlumno.aspx"><i class="fa-solid fa-user"></i> Mi Perfil</a>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 style="color: black;">Matrícula Online</h2>
    <div class="container-matricula" style="display:block;">
        <h2 style="color: black">Confirmar Datos Personaes</h2>
        <div class="form-section">
            <h3>Datos del alumno</h3>
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
                    <asp:TextBox ID="txtDNIAlumno" runat="server" placeholder="DNI" required="required" CssClass="form-control"></asp:TextBox>
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
        <div class="form-section">
            <h3>Adjuntar Certificados</h3>
            <div class="form-group">
                <div class="form-row">
                    <label for="fileCertificadoEstudios">Certificado de Estudios:</label>
                    <asp:FileUpload ID="fileCertificadoEstudios" runat="server" CssClass="file-upload" />
                </div>
                <div class="form-row" style="margin-top: 48px;">
                    <asp:LinkButton ID="lnkDescargarEstudios" runat="server" CssClass="button-style" OnClick="lnkDescargarEstudios_Click">
                        Descargar Certificado de Estudios
                    </asp:LinkButton>
                </div>
             </div>
            <div class="form-group">
                <div class="form-row">
                    <label for="fileCertificadoSalud">Certificado de Salud:</label>
                    <asp:FileUpload ID="fileCertificadoSalud" runat="server" CssClass="file-upload" />
                </div>
                <div class="form-row" style="margin-top: 48px;">
                    <asp:LinkButton ID="lnkDescargarSalud" runat="server" CssClass="button-style" OnClick="lnkDescargarSalud_Click">
                        Descargar Certificado de Salud
                    </asp:LinkButton>
                </div>
            </div>
        </div>
        <div class="button-group">
            <asp:Button ID="btnRegrasar" runat="server" Text="Regresar" OnClick="btnRegresar_Click" CssClass="button-style" />
            <asp:Button ID="btnGuardar" runat="server" Text="Confirmar Matricula" OnClick="btnGuardar_Click" CssClass="btn btn-secondary" />
        </div>
    </div>
</asp:Content>
