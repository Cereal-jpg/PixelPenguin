﻿<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="VerInfoGradoProfesor.aspx.cs" Inherits="SoftPixelPenguinsWA.Flujo_Profesor.VerInfoGradoProfesor" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Inicio - Profesor
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexProfesor.aspx"><i class="fa-solid fa-home"></i> Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="CursosDictadosProfesor.aspx"><i class="fa-solid fa-book"></i> Cursos Dictados</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="RegistroNotasProfesor.aspx"><i class="fa-solid fa-bar-chart"></i> Registro de notas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="MiPerfilProfesor.aspx"><i class="fa-solid fa-user"></i> Mi perfil</a>
    </asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">

    <h2 style="text-align: left; color: #000f;">Profesor - Cursos Dictados - Información del Grado</h2>
    <div class="container-matricula" style="display:block;">
        <h2 style="color: black;">Datos del Grado Académico</h2>
        <div class="form-group">
            <div class="form-row">
                <label>Grado:</label>
                <asp:TextBox ID="txtGrado" runat="server" placeholder="Grado"></asp:TextBox>
            </div>
            <div class="form-row">
                <label>Nivel:</label>
                <asp:TextBox ID="txtNivel" runat="server" placeholder="Nivel"></asp:TextBox>
            </div>
        </div>
        <div class="form-group">
            <div class="form-row">
                <label>Cantidad de Alumnos:</label>
                <asp:TextBox ID="txtCantAlumnos" runat="server" placeholder="CantAlumnos"></asp:TextBox>
            </div>
        </div>
        <div style="display: flex; justify-content: center; align-items: center;">
            <br>
            <asp:Button ID="btnRegresar" runat="server" Text="Regresar" OnClick="btnRegresar_Click" CssClass="btn btn-primary" />
        </div>
    </div>
</asp:Content>