<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="GestionarUsuariosAdmin.aspx.cs" Inherits="SoftPixelPenguinsWA.GestionarUsuariosAdmin" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestionar Usuarios - Admin
</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexAdmin.aspx"><i class="fa-solid fa-home"></i>Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="ReportesAdmin.aspx"><i class="fa-solid fa-book"></i>Reportes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="BusquedaAdmin.aspx"><i class="fa-solid fa-search"></i>Busqueda</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="AgregarPlanAdmin.aspx"><i class="fa-solid fa-folder-plus"></i>Agregar Plan</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="GestionarUsuariosAdmin.aspx"><i class="fa-solid fa-users"></i>Gestionar Usuarios</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="MiPerfilAdmin.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="cphContenido" runat="server">

    <style>

        .form-row{
            flex: 1;
            min-width: 160px;
        }

        .file-upload {
            display: inline-block;
            width: 100%;
            padding: 10px;
            font-size: 14px;
            color: #555;
            background-color: #f5f5f5;
            border: 1px solid #ccc;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

    </style>

    <div class="d-flex justify-content-between align-items-center mt-3 mx-3">
        <h1>Gestionar Usuarios</h1>
    </div>
    <hr class="mx-3" />
        <div class="container mt-5">
            <div class="row">
                <div class="col-12 d-flex justify-content-between align-items-center mb-4 pt-3">
                    <!-- Barra de búsqueda con botón -->
                    <div class="input-group w-50">
                        <asp:TextBox ID="txtBuscarUsuario" runat="server" CssClass="form-control" placeholder="Buscar usuario..." aria-label="Buscar usuario"></asp:TextBox>
                        <asp:LinkButton ID="lbBuscar" runat="server" CssClass="btn btn-outline-primary" OnClick="lbBuscar_Click">
                        <i class="fa-solid fa-search"></i> Buscar
                     </asp:LinkButton>
                    </div>

                    <!-- Botón para agregar un nuevo usuario -->
                    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addUserModal">
                        <i class="fa-solid fa-user-plus"></i> Agregar Nuevo Usuario
                    </button>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <asp:GridView ID="gvUsuarios" runat="server" AutoGenerateColumns="False" CssClass="table table-striped table-bordered" Style="background-color: transparent;">
                        <Columns>
                            <asp:BoundField HeaderText="Email" DataField="email" />
                            <asp:BoundField HeaderText="Usuario" DataField="username" />
                            <asp:BoundField HeaderText="Nombre Completo" DataField="nombreCompleto" />
                            <asp:BoundField HeaderText="Rol" DataField="rol.nombre" />
                            <asp:TemplateField HeaderText="Acciones">
                                <ItemTemplate>
                                    <asp:LinkButton ID="lnkEdit" runat="server" 
                                        CommandArgument='<%# Eval("idUsuario") %>' 
                                        CssClass="btn btn-warning btn-sm me-1" 
                                        OnClick="lbEditar_Click">
                                        <i class="fa-solid fa-pen-to-square"></i> Editar
                                    </asp:LinkButton>

                                    <asp:LinkButton ID="lnkDelete" runat="server" 
                                        CommandArgument='<%# Eval("idUsuario") %>' 
                                        CssClass="btn btn-danger btn-sm" 
                                        OnClick="lbEliminar_Click">
                                        <i class="fa-solid fa-trash"></i> Eliminar
                                    </asp:LinkButton>
                                </ItemTemplate>
                            </asp:TemplateField>
                        </Columns>
                    </asp:GridView>
                </div>
            </div>
        </div>
    <!-- Modal Agregar/Editar Usuario -->
    <div class="modal fade" id="addUserModal" tabindex="-1" aria-labelledby="addUserModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h2 class="text-dark"><asp:Label ID="lblTitulo" runat="server" Text="Agregar Usuario"></asp:Label></h2>
                </div>
                <div class="modal-body">
                    <form id="userForm">
                        <div class="mb-3">
                            <label for="nombreCompleto" class="form-label">Nombre Completo</label>
                            <input type="text" class="form-control" id="nombreCompleto" runat="server" placeholder="Ingrese el nombre completo" required />
                        </div>

                        <div class="mb-3">
                            <label for="dni" class="form-label">DNI</label>
                            <input type="text" class="form-control" id="dni" runat="server" placeholder="Ingrese el DNI" required />
                        </div>

                        <div class="mb-3">
                            <div class="col-md-6">
                                <asp:Label ID="lblFechaNacimiento" runat="server" Text="Fecha de Nacimiento:" CssClass="col-form-label fw-bold"></asp:Label>
                                <input id="dtpFechaNacimiento" runat="server" type="date" class="form-control" required />
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="direccion" class="form-label">Dirección</label>
                            <input type="text" class="form-control" id="direccion" runat="server" placeholder="Ingrese la dirección" required />
                        </div>

                        <div class="mb-3">
                            <label for="userEmail" class="form-label">Email</label>
                            <input type="email" class="form-control" id="userEmail" runat="server" placeholder="Ingrese el email" required />
                        </div>

                        <div class="mb-3">
                            <label for="sexo" class="form-label">Sexo</label>
                            <select id="sexo" class="form-select" runat="server" required>
                                <option value="">Seleccione el sexo</option>
                                <option value="Masculino">Masculino</option>
                                <option value="Femenino">Femenino</option>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label for="username" class="form-label">Nombre de Usuario</label>
                            <input type="text" class="form-control" id="username" runat="server" placeholder="Ingrese el nombre de usuario" required />
                        </div>

                        <div class="mb-3">
                            <label for="password" class="form-label">Contraseña</label>
                            <input type="password" class="form-control" id="password" runat="server" placeholder="Ingrese la contraseña" required />
                        </div>
                        <div class="mb-3">
                            <label for="ddlRoles" class="form-label">Seleccione un rol</label>
                            <div class="input-group">
                                <asp:DropDownList ID="ddlRoles" runat="server" AutoPostBack="false" OnChange="mostrarCampos()" CssClass="form-select">
                                </asp:DropDownList>
                            </div>
                        </div>

                        <!-- Campos específicos para Alumno -->
                        <div id="alumnoFields" class="mb-3" style="display: none;">
                            <div class="mb-3">
                                <label for="codigoAlumno" class="form-label">Código Alumno</label>
                                <asp:TextBox ID="codigoAlumno" runat="server" CssClass="form-control" placeholder="Ingrese el código del alumno"></asp:TextBox>
                            </div>
                            <div class="form-check mb-3">
                                <asp:CheckBox ID="conCertificadoDeEstudios" runat="server" CssClass="form-check-input" />
                                <label class="form-check-label" for="conCertificadoDeEstudios">Con Certificado de Estudios</label>
                            </div>
                            <div class="form-check mb-3">
                                <asp:CheckBox ID="conCertificadoDeSalud" runat="server" CssClass="form-check-input" />
                                <label class="form-check-label" for="conCertificadoDeSalud">Con Certificado de Salud</label>
                            </div>
                            <div class="form-check mb-3">
                                <asp:CheckBox ID="conDeuda" runat="server" CssClass="form-check-input" />
                                <label class="form-check-label" for="conDeuda">Con Deuda</label>
                            </div>
                            <div class="mb-3">
                                <label for="apoderado" class="form-label">Apoderado (ID)</label>
                                <asp:TextBox ID="apoderado" runat="server" CssClass="form-control" placeholder="Ingrese el ID del apoderado"></asp:TextBox>
                            </div>
                            <div class="mb-3">
                                <label for="gradoAcademico" class="form-label">Grado Académico (ID)</label>
                                <asp:TextBox ID="gradoAcademico" runat="server" CssClass="form-control" placeholder="Ingrese el ID del grado académico"></asp:TextBox>
                            </div>
                        </div>

                        <!-- Campos específicos para Profesor -->
                        <div id="profesorFields" class="mb-3" style="display: none;">
                            <div class="mb-3">
                                <label for="codigoProfesor" class="form-label">Código Profesor</label>
                                <asp:TextBox ID="codigoProfesor" runat="server" CssClass="form-control" placeholder="Ingrese el código del profesor"></asp:TextBox>
                            </div>
                            <div class="form-row">
                                <label for="fileCertificadoEducativo">Certificado de Estudios:</label>
                                <asp:FileUpload ID="fileCertificadoEducativo" runat="server" CssClass="file-upload" />
                            </div>
                            <div class="mb-3">
                                <label for="especialidad" class="form-label">Especialidad</label>
                                <asp:TextBox ID="especialidad" runat="server" CssClass="form-control" placeholder="Ingrese la especialidad"></asp:TextBox>
                            </div>
                        </div>

                        <!-- Campos específicos para Personal Administrativo -->
                        <div id="personalFields" class="mb-3" style="display: none;">
                            <div class="mb-3">
                                <label for="codigoPersonalAdministrativo" class="form-label">Código Personal Administrativo</label>
                                <asp:TextBox ID="codigoPersonalAdministrativo" runat="server" CssClass="form-control" placeholder="Ingrese el código del personal administrativo"></asp:TextBox>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <asp:LinkButton ID="lbRegresar" runat="server" 
                        Text="<i class='fa-solid fa-rotate-left'></i> Regresar" 
                        CssClass="float-start btn btn-secondary" 
                        OnClick="lbRegresar_Click" />

                    <asp:LinkButton ID="lbGuardar" runat="server" 
                        Text="<i class='fa-regular fa-floppy-disk'></i> Guardar" 
                        CssClass="float-end btn btn-primary" 
                        OnClick="lbGuardar_Click" />
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript">
        function mostrarCampos() {
            var rolSeleccionado = document.getElementById('<%= ddlRoles.ClientID %>').value;
            // Ocultar todos los campos
            document.getElementById('alumnoFields').style.display = 'none';
            document.getElementById('profesorFields').style.display = 'none';
            document.getElementById('personalFields').style.display = 'none';

            // Mostrar campos basados en el rol seleccionado
            if (rolSeleccionado === "1") { // Alumno
                document.getElementById('alumnoFields').style.display = 'block';
            } else if (rolSeleccionado === "2") { // Profesor
                document.getElementById('profesorFields').style.display = 'block';
            } else if (rolSeleccionado === "3") { // Personal Administrativo
                document.getElementById('personalFields').style.display = 'block';
            }
        }

        function openModal() {
            const modal = new bootstrap.Modal(document.getElementById('addUserModal'));
            modal.show();
        }

        function clearAndCloseModal() {
            // Limpiar todos los campos del modal
            document.getElementById('<%= dni.ClientID %>').value = '';
            document.getElementById('<%= nombreCompleto.ClientID %>').value = '';
            document.getElementById('<%= dtpFechaNacimiento.ClientID %>').value = '';
            document.getElementById('<%= direccion.ClientID %>').value = '';
            document.getElementById('<%= userEmail.ClientID %>').value = '';
            document.getElementById('<%= sexo.ClientID %>').value = '';
            document.getElementById('<%= username.ClientID %>').value = '';
            document.getElementById('<%= password.ClientID %>').value = '';
            document.getElementById('<%= codigoAlumno.ClientID %>').value = '';
            document.getElementById('<%= apoderado.ClientID %>').value = '';
            document.getElementById('<%= gradoAcademico.ClientID %>').value = '';
            var rolDropdown = document.getElementById('<%= ddlRoles.ClientID %>');
            if (rolDropdown) {
                rolDropdown.disabled = false;
                rolDropdown.selectedIndex = 0;
            }

            // Limpiar campos específicos del rol que son ocultos
            document.getElementById('<%= codigoAlumno.ClientID %>').value = '';
            document.getElementById('<%= conCertificadoDeEstudios.ClientID %>').checked = false;
            document.getElementById('<%= conCertificadoDeSalud.ClientID %>').checked = false;
            document.getElementById('<%= conDeuda.ClientID %>').checked = false;
            document.getElementById('<%= apoderado.ClientID %>').value = ''; 
            document.getElementById('<%= gradoAcademico.ClientID %>').value = '';
    
            document.getElementById('<%= codigoProfesor.ClientID %>').value = ''; 
            document.getElementById('<%= fileCertificadoEducativo.ClientID %>').checked = false;
            document.getElementById('<%= especialidad.ClientID %>').value = '';

            document.getElementById('<%= codigoPersonalAdministrativo.ClientID %>').value = '';

            document.getElementById('alumnoFields').style.display = 'none';
            document.getElementById('profesorFields').style.display = 'none';
            document.getElementById('personalFields').style.display = 'none';
            document.getElementById('<%= lblTitulo.ClientID %>').innerText = "Aregar Usuario";
            // Cerrar el modal
            $('#addUserModal').modal('hide');
        }

    </script>

</asp:Content>

