<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="MatriculaOnlineUserGenerico.aspx.cs" Inherits="SoftPixelPenguinsWA.Flujo_Generico.MatriculaOnlineUserGenerico" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
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
    <h2 style="text-align: left; color: #000f;">Matrícula Online</h2>
    <link rel="stylesheet" href="../Content/Estilos-Alumno.css" />
    <div class="container-matricula">
        <div class="matricula-section">
            <h3><i class="fas fa-lightbulb icon-color"></i>¡Hola!</h3>    
            <p>Bienvenido a la Matrícula online</p>
            <p>En este espacio podrás consultar y continuar con tu proceso de matrícula</p>
            <div class="button-container">
                <asp:Button ID="btnConsultarMatricula" runat="server" Text="Consultar Matrícula" CssClass="btn-matricula" OnClick="btnConsultarMatricula_Click" />
            </div>
        </div>
        <div class="image-section">
            <img src="../Images/CHICOMAT.png" alt="Horario Académico" class="responsive-image"/>
        </div>
    </div>
</asp:Content>
