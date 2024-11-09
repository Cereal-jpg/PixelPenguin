<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="IndexProfesor.aspx.cs" Inherits="SoftPixelPenguinsWA.IndexProfesor" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Home - Profesor
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexProfesor.aspx"><i class="fa-solid fa-home"></i>Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="CursosDictadosProfesor.aspx"><i class="fa-solid fa-book"></i>Cursos Dictados</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="RegistroNotasProfesor.aspx"><i class="fa-solid fa-bar-chart"></i>Registro de notas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="MiPerfilProfesor.aspx"><i class="fa-solid fa-user"></i>Mi perfil</a>
    </asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="MiPerfilProfesor.aspx"><i class="fa-solid fa-user"></i>Mi perfil</a>
    </asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="MiPerfilProfesor.aspx"><i class="fa-solid fa-user"></i>Mi perfil</a>
    </asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 style="text-align: left; color: #000f;">Profesor - Inicio Profesor</h2>
    <link rel="stylesheet" href="Content/Estilos-Alumno.css" />
    <div class="container-al">
        <div class="schedule">
            <h3>Horario del Profesor</h3>
            <img src="Images/Horario.jpg" alt="Horario Académico" />
        </div>
        <div class="notifications">
            <h3>Notificaciones</h3>
            <ul class="notification-list">
                <li>Próximo curso a dictar: </li>
                <li>Práctica de matemáticas para el 20/08/2024</li>
            </ul>
        </div>
    </div>
</asp:Content>
