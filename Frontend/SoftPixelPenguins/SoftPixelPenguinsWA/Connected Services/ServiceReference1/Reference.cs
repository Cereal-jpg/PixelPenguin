﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace SoftPixelPenguinsWA.ServiceReference1 {
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(Namespace="http://services.usuario.pixelpenguins.pucp.edu.pe", ConfigurationName="ServiceReference1.UsuarioWS")]
    public interface UsuarioWS {
        
        // CODEGEN: El parámetro 'return' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/obtenerUsuarioPorIdRe" +
            "quest", ReplyAction="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/obtenerUsuarioPorIdRe" +
            "sponse")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        SoftPixelPenguinsWA.ServiceReference1.obtenerUsuarioPorIdResponse obtenerUsuarioPorId(SoftPixelPenguinsWA.ServiceReference1.obtenerUsuarioPorIdRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/obtenerUsuarioPorIdRe" +
            "quest", ReplyAction="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/obtenerUsuarioPorIdRe" +
            "sponse")]
        System.Threading.Tasks.Task<SoftPixelPenguinsWA.ServiceReference1.obtenerUsuarioPorIdResponse> obtenerUsuarioPorIdAsync(SoftPixelPenguinsWA.ServiceReference1.obtenerUsuarioPorIdRequest request);
        
        // CODEGEN: El parámetro 'return' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/listarTodosUsuariosRe" +
            "quest", ReplyAction="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/listarTodosUsuariosRe" +
            "sponse")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        SoftPixelPenguinsWA.ServiceReference1.listarTodosUsuariosResponse listarTodosUsuarios(SoftPixelPenguinsWA.ServiceReference1.listarTodosUsuariosRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/listarTodosUsuariosRe" +
            "quest", ReplyAction="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/listarTodosUsuariosRe" +
            "sponse")]
        System.Threading.Tasks.Task<SoftPixelPenguinsWA.ServiceReference1.listarTodosUsuariosResponse> listarTodosUsuariosAsync(SoftPixelPenguinsWA.ServiceReference1.listarTodosUsuariosRequest request);
        
        // CODEGEN: El parámetro 'return' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/existeUsuarioRequest", ReplyAction="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/existeUsuarioResponse" +
            "")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        SoftPixelPenguinsWA.ServiceReference1.existeUsuarioResponse existeUsuario(SoftPixelPenguinsWA.ServiceReference1.existeUsuarioRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/existeUsuarioRequest", ReplyAction="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/existeUsuarioResponse" +
            "")]
        System.Threading.Tasks.Task<SoftPixelPenguinsWA.ServiceReference1.existeUsuarioResponse> existeUsuarioAsync(SoftPixelPenguinsWA.ServiceReference1.existeUsuarioRequest request);
        
        // CODEGEN: El parámetro 'return' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/modificarUsuarioReque" +
            "st", ReplyAction="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/modificarUsuarioRespo" +
            "nse")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        SoftPixelPenguinsWA.ServiceReference1.modificarUsuarioResponse modificarUsuario(SoftPixelPenguinsWA.ServiceReference1.modificarUsuarioRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/modificarUsuarioReque" +
            "st", ReplyAction="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/modificarUsuarioRespo" +
            "nse")]
        System.Threading.Tasks.Task<SoftPixelPenguinsWA.ServiceReference1.modificarUsuarioResponse> modificarUsuarioAsync(SoftPixelPenguinsWA.ServiceReference1.modificarUsuarioRequest request);
        
        // CODEGEN: El parámetro 'return' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/insertarUsuarioReques" +
            "t", ReplyAction="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/insertarUsuarioRespon" +
            "se")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        SoftPixelPenguinsWA.ServiceReference1.insertarUsuarioResponse insertarUsuario(SoftPixelPenguinsWA.ServiceReference1.insertarUsuarioRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/insertarUsuarioReques" +
            "t", ReplyAction="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/insertarUsuarioRespon" +
            "se")]
        System.Threading.Tasks.Task<SoftPixelPenguinsWA.ServiceReference1.insertarUsuarioResponse> insertarUsuarioAsync(SoftPixelPenguinsWA.ServiceReference1.insertarUsuarioRequest request);
        
        // CODEGEN: El parámetro 'return' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/eliminarUsuarioReques" +
            "t", ReplyAction="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/eliminarUsuarioRespon" +
            "se")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        SoftPixelPenguinsWA.ServiceReference1.eliminarUsuarioResponse eliminarUsuario(SoftPixelPenguinsWA.ServiceReference1.eliminarUsuarioRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/eliminarUsuarioReques" +
            "t", ReplyAction="http://services.usuario.pixelpenguins.pucp.edu.pe/UsuarioWS/eliminarUsuarioRespon" +
            "se")]
        System.Threading.Tasks.Task<SoftPixelPenguinsWA.ServiceReference1.eliminarUsuarioResponse> eliminarUsuarioAsync(SoftPixelPenguinsWA.ServiceReference1.eliminarUsuarioRequest request);
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.8.9032.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://services.usuario.pixelpenguins.pucp.edu.pe")]
    public abstract partial class usuario : object, System.ComponentModel.INotifyPropertyChanged {
        
        private string direccionField;
        
        private string dniField;
        
        private string emailField;
        
        private System.DateTime fechaNacimientoField;
        
        private bool fechaNacimientoFieldSpecified;
        
        private int idUsuarioField;
        
        private string nombreCompletoField;
        
        private string passwordField;
        
        private rol rolField;
        
        private string sexoField;
        
        private string usernameField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public string direccion {
            get {
                return this.direccionField;
            }
            set {
                this.direccionField = value;
                this.RaisePropertyChanged("direccion");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=1)]
        public string dni {
            get {
                return this.dniField;
            }
            set {
                this.dniField = value;
                this.RaisePropertyChanged("dni");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=2)]
        public string email {
            get {
                return this.emailField;
            }
            set {
                this.emailField = value;
                this.RaisePropertyChanged("email");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=3)]
        public System.DateTime fechaNacimiento {
            get {
                return this.fechaNacimientoField;
            }
            set {
                this.fechaNacimientoField = value;
                this.RaisePropertyChanged("fechaNacimiento");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool fechaNacimientoSpecified {
            get {
                return this.fechaNacimientoFieldSpecified;
            }
            set {
                this.fechaNacimientoFieldSpecified = value;
                this.RaisePropertyChanged("fechaNacimientoSpecified");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=4)]
        public int idUsuario {
            get {
                return this.idUsuarioField;
            }
            set {
                this.idUsuarioField = value;
                this.RaisePropertyChanged("idUsuario");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=5)]
        public string nombreCompleto {
            get {
                return this.nombreCompletoField;
            }
            set {
                this.nombreCompletoField = value;
                this.RaisePropertyChanged("nombreCompleto");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=6)]
        public string password {
            get {
                return this.passwordField;
            }
            set {
                this.passwordField = value;
                this.RaisePropertyChanged("password");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=7)]
        public rol rol {
            get {
                return this.rolField;
            }
            set {
                this.rolField = value;
                this.RaisePropertyChanged("rol");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=8)]
        public string sexo {
            get {
                return this.sexoField;
            }
            set {
                this.sexoField = value;
                this.RaisePropertyChanged("sexo");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=9)]
        public string username {
            get {
                return this.usernameField;
            }
            set {
                this.usernameField = value;
                this.RaisePropertyChanged("username");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.8.9032.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://services.usuario.pixelpenguins.pucp.edu.pe")]
    public partial class rol : object, System.ComponentModel.INotifyPropertyChanged {
        
        private int idRolField;
        
        private string nombreField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public int idRol {
            get {
                return this.idRolField;
            }
            set {
                this.idRolField = value;
                this.RaisePropertyChanged("idRol");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=1)]
        public string nombre {
            get {
                return this.nombreField;
            }
            set {
                this.nombreField = value;
                this.RaisePropertyChanged("nombre");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="obtenerUsuarioPorId", WrapperNamespace="http://services.usuario.pixelpenguins.pucp.edu.pe", IsWrapped=true)]
    public partial class obtenerUsuarioPorIdRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://services.usuario.pixelpenguins.pucp.edu.pe", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public int idUsuario;
        
        public obtenerUsuarioPorIdRequest() {
        }
        
        public obtenerUsuarioPorIdRequest(int idUsuario) {
            this.idUsuario = idUsuario;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="obtenerUsuarioPorIdResponse", WrapperNamespace="http://services.usuario.pixelpenguins.pucp.edu.pe", IsWrapped=true)]
    public partial class obtenerUsuarioPorIdResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://services.usuario.pixelpenguins.pucp.edu.pe", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public SoftPixelPenguinsWA.ServiceReference1.usuario @return;
        
        public obtenerUsuarioPorIdResponse() {
        }
        
        public obtenerUsuarioPorIdResponse(SoftPixelPenguinsWA.ServiceReference1.usuario @return) {
            this.@return = @return;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="listarTodosUsuarios", WrapperNamespace="http://services.usuario.pixelpenguins.pucp.edu.pe", IsWrapped=true)]
    public partial class listarTodosUsuariosRequest {
        
        public listarTodosUsuariosRequest() {
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="listarTodosUsuariosResponse", WrapperNamespace="http://services.usuario.pixelpenguins.pucp.edu.pe", IsWrapped=true)]
    public partial class listarTodosUsuariosResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://services.usuario.pixelpenguins.pucp.edu.pe", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public SoftPixelPenguinsWA.ServiceReference1.usuario[] @return;
        
        public listarTodosUsuariosResponse() {
        }
        
        public listarTodosUsuariosResponse(SoftPixelPenguinsWA.ServiceReference1.usuario[] @return) {
            this.@return = @return;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="existeUsuario", WrapperNamespace="http://services.usuario.pixelpenguins.pucp.edu.pe", IsWrapped=true)]
    public partial class existeUsuarioRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://services.usuario.pixelpenguins.pucp.edu.pe", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public SoftPixelPenguinsWA.ServiceReference1.usuario usuario;
        
        public existeUsuarioRequest() {
        }
        
        public existeUsuarioRequest(SoftPixelPenguinsWA.ServiceReference1.usuario usuario) {
            this.usuario = usuario;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="existeUsuarioResponse", WrapperNamespace="http://services.usuario.pixelpenguins.pucp.edu.pe", IsWrapped=true)]
    public partial class existeUsuarioResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://services.usuario.pixelpenguins.pucp.edu.pe", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public bool @return;
        
        public existeUsuarioResponse() {
        }
        
        public existeUsuarioResponse(bool @return) {
            this.@return = @return;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="modificarUsuario", WrapperNamespace="http://services.usuario.pixelpenguins.pucp.edu.pe", IsWrapped=true)]
    public partial class modificarUsuarioRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://services.usuario.pixelpenguins.pucp.edu.pe", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public SoftPixelPenguinsWA.ServiceReference1.usuario usuario;
        
        public modificarUsuarioRequest() {
        }
        
        public modificarUsuarioRequest(SoftPixelPenguinsWA.ServiceReference1.usuario usuario) {
            this.usuario = usuario;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="modificarUsuarioResponse", WrapperNamespace="http://services.usuario.pixelpenguins.pucp.edu.pe", IsWrapped=true)]
    public partial class modificarUsuarioResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://services.usuario.pixelpenguins.pucp.edu.pe", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public int @return;
        
        public modificarUsuarioResponse() {
        }
        
        public modificarUsuarioResponse(int @return) {
            this.@return = @return;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="insertarUsuario", WrapperNamespace="http://services.usuario.pixelpenguins.pucp.edu.pe", IsWrapped=true)]
    public partial class insertarUsuarioRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://services.usuario.pixelpenguins.pucp.edu.pe", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public SoftPixelPenguinsWA.ServiceReference1.usuario usuario;
        
        public insertarUsuarioRequest() {
        }
        
        public insertarUsuarioRequest(SoftPixelPenguinsWA.ServiceReference1.usuario usuario) {
            this.usuario = usuario;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="insertarUsuarioResponse", WrapperNamespace="http://services.usuario.pixelpenguins.pucp.edu.pe", IsWrapped=true)]
    public partial class insertarUsuarioResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://services.usuario.pixelpenguins.pucp.edu.pe", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public int @return;
        
        public insertarUsuarioResponse() {
        }
        
        public insertarUsuarioResponse(int @return) {
            this.@return = @return;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="eliminarUsuario", WrapperNamespace="http://services.usuario.pixelpenguins.pucp.edu.pe", IsWrapped=true)]
    public partial class eliminarUsuarioRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://services.usuario.pixelpenguins.pucp.edu.pe", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public SoftPixelPenguinsWA.ServiceReference1.usuario usuario;
        
        public eliminarUsuarioRequest() {
        }
        
        public eliminarUsuarioRequest(SoftPixelPenguinsWA.ServiceReference1.usuario usuario) {
            this.usuario = usuario;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="eliminarUsuarioResponse", WrapperNamespace="http://services.usuario.pixelpenguins.pucp.edu.pe", IsWrapped=true)]
    public partial class eliminarUsuarioResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://services.usuario.pixelpenguins.pucp.edu.pe", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public int @return;
        
        public eliminarUsuarioResponse() {
        }
        
        public eliminarUsuarioResponse(int @return) {
            this.@return = @return;
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface UsuarioWSChannel : SoftPixelPenguinsWA.ServiceReference1.UsuarioWS, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class UsuarioWSClient : System.ServiceModel.ClientBase<SoftPixelPenguinsWA.ServiceReference1.UsuarioWS>, SoftPixelPenguinsWA.ServiceReference1.UsuarioWS {
        
        public UsuarioWSClient() {
        }
        
        public UsuarioWSClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public UsuarioWSClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public UsuarioWSClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public UsuarioWSClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        SoftPixelPenguinsWA.ServiceReference1.obtenerUsuarioPorIdResponse SoftPixelPenguinsWA.ServiceReference1.UsuarioWS.obtenerUsuarioPorId(SoftPixelPenguinsWA.ServiceReference1.obtenerUsuarioPorIdRequest request) {
            return base.Channel.obtenerUsuarioPorId(request);
        }
        
        public SoftPixelPenguinsWA.ServiceReference1.usuario obtenerUsuarioPorId(int idUsuario) {
            SoftPixelPenguinsWA.ServiceReference1.obtenerUsuarioPorIdRequest inValue = new SoftPixelPenguinsWA.ServiceReference1.obtenerUsuarioPorIdRequest();
            inValue.idUsuario = idUsuario;
            SoftPixelPenguinsWA.ServiceReference1.obtenerUsuarioPorIdResponse retVal = ((SoftPixelPenguinsWA.ServiceReference1.UsuarioWS)(this)).obtenerUsuarioPorId(inValue);
            return retVal.@return;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<SoftPixelPenguinsWA.ServiceReference1.obtenerUsuarioPorIdResponse> SoftPixelPenguinsWA.ServiceReference1.UsuarioWS.obtenerUsuarioPorIdAsync(SoftPixelPenguinsWA.ServiceReference1.obtenerUsuarioPorIdRequest request) {
            return base.Channel.obtenerUsuarioPorIdAsync(request);
        }
        
        public System.Threading.Tasks.Task<SoftPixelPenguinsWA.ServiceReference1.obtenerUsuarioPorIdResponse> obtenerUsuarioPorIdAsync(int idUsuario) {
            SoftPixelPenguinsWA.ServiceReference1.obtenerUsuarioPorIdRequest inValue = new SoftPixelPenguinsWA.ServiceReference1.obtenerUsuarioPorIdRequest();
            inValue.idUsuario = idUsuario;
            return ((SoftPixelPenguinsWA.ServiceReference1.UsuarioWS)(this)).obtenerUsuarioPorIdAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        SoftPixelPenguinsWA.ServiceReference1.listarTodosUsuariosResponse SoftPixelPenguinsWA.ServiceReference1.UsuarioWS.listarTodosUsuarios(SoftPixelPenguinsWA.ServiceReference1.listarTodosUsuariosRequest request) {
            return base.Channel.listarTodosUsuarios(request);
        }
        
        public SoftPixelPenguinsWA.ServiceReference1.usuario[] listarTodosUsuarios() {
            SoftPixelPenguinsWA.ServiceReference1.listarTodosUsuariosRequest inValue = new SoftPixelPenguinsWA.ServiceReference1.listarTodosUsuariosRequest();
            SoftPixelPenguinsWA.ServiceReference1.listarTodosUsuariosResponse retVal = ((SoftPixelPenguinsWA.ServiceReference1.UsuarioWS)(this)).listarTodosUsuarios(inValue);
            return retVal.@return;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<SoftPixelPenguinsWA.ServiceReference1.listarTodosUsuariosResponse> SoftPixelPenguinsWA.ServiceReference1.UsuarioWS.listarTodosUsuariosAsync(SoftPixelPenguinsWA.ServiceReference1.listarTodosUsuariosRequest request) {
            return base.Channel.listarTodosUsuariosAsync(request);
        }
        
        public System.Threading.Tasks.Task<SoftPixelPenguinsWA.ServiceReference1.listarTodosUsuariosResponse> listarTodosUsuariosAsync() {
            SoftPixelPenguinsWA.ServiceReference1.listarTodosUsuariosRequest inValue = new SoftPixelPenguinsWA.ServiceReference1.listarTodosUsuariosRequest();
            return ((SoftPixelPenguinsWA.ServiceReference1.UsuarioWS)(this)).listarTodosUsuariosAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        SoftPixelPenguinsWA.ServiceReference1.existeUsuarioResponse SoftPixelPenguinsWA.ServiceReference1.UsuarioWS.existeUsuario(SoftPixelPenguinsWA.ServiceReference1.existeUsuarioRequest request) {
            return base.Channel.existeUsuario(request);
        }
        
        public bool existeUsuario(SoftPixelPenguinsWA.ServiceReference1.usuario usuario) {
            SoftPixelPenguinsWA.ServiceReference1.existeUsuarioRequest inValue = new SoftPixelPenguinsWA.ServiceReference1.existeUsuarioRequest();
            inValue.usuario = usuario;
            SoftPixelPenguinsWA.ServiceReference1.existeUsuarioResponse retVal = ((SoftPixelPenguinsWA.ServiceReference1.UsuarioWS)(this)).existeUsuario(inValue);
            return retVal.@return;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<SoftPixelPenguinsWA.ServiceReference1.existeUsuarioResponse> SoftPixelPenguinsWA.ServiceReference1.UsuarioWS.existeUsuarioAsync(SoftPixelPenguinsWA.ServiceReference1.existeUsuarioRequest request) {
            return base.Channel.existeUsuarioAsync(request);
        }
        
        public System.Threading.Tasks.Task<SoftPixelPenguinsWA.ServiceReference1.existeUsuarioResponse> existeUsuarioAsync(SoftPixelPenguinsWA.ServiceReference1.usuario usuario) {
            SoftPixelPenguinsWA.ServiceReference1.existeUsuarioRequest inValue = new SoftPixelPenguinsWA.ServiceReference1.existeUsuarioRequest();
            inValue.usuario = usuario;
            return ((SoftPixelPenguinsWA.ServiceReference1.UsuarioWS)(this)).existeUsuarioAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        SoftPixelPenguinsWA.ServiceReference1.modificarUsuarioResponse SoftPixelPenguinsWA.ServiceReference1.UsuarioWS.modificarUsuario(SoftPixelPenguinsWA.ServiceReference1.modificarUsuarioRequest request) {
            return base.Channel.modificarUsuario(request);
        }
        
        public int modificarUsuario(SoftPixelPenguinsWA.ServiceReference1.usuario usuario) {
            SoftPixelPenguinsWA.ServiceReference1.modificarUsuarioRequest inValue = new SoftPixelPenguinsWA.ServiceReference1.modificarUsuarioRequest();
            inValue.usuario = usuario;
            SoftPixelPenguinsWA.ServiceReference1.modificarUsuarioResponse retVal = ((SoftPixelPenguinsWA.ServiceReference1.UsuarioWS)(this)).modificarUsuario(inValue);
            return retVal.@return;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<SoftPixelPenguinsWA.ServiceReference1.modificarUsuarioResponse> SoftPixelPenguinsWA.ServiceReference1.UsuarioWS.modificarUsuarioAsync(SoftPixelPenguinsWA.ServiceReference1.modificarUsuarioRequest request) {
            return base.Channel.modificarUsuarioAsync(request);
        }
        
        public System.Threading.Tasks.Task<SoftPixelPenguinsWA.ServiceReference1.modificarUsuarioResponse> modificarUsuarioAsync(SoftPixelPenguinsWA.ServiceReference1.usuario usuario) {
            SoftPixelPenguinsWA.ServiceReference1.modificarUsuarioRequest inValue = new SoftPixelPenguinsWA.ServiceReference1.modificarUsuarioRequest();
            inValue.usuario = usuario;
            return ((SoftPixelPenguinsWA.ServiceReference1.UsuarioWS)(this)).modificarUsuarioAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        SoftPixelPenguinsWA.ServiceReference1.insertarUsuarioResponse SoftPixelPenguinsWA.ServiceReference1.UsuarioWS.insertarUsuario(SoftPixelPenguinsWA.ServiceReference1.insertarUsuarioRequest request) {
            return base.Channel.insertarUsuario(request);
        }
        
        public int insertarUsuario(SoftPixelPenguinsWA.ServiceReference1.usuario usuario) {
            SoftPixelPenguinsWA.ServiceReference1.insertarUsuarioRequest inValue = new SoftPixelPenguinsWA.ServiceReference1.insertarUsuarioRequest();
            inValue.usuario = usuario;
            SoftPixelPenguinsWA.ServiceReference1.insertarUsuarioResponse retVal = ((SoftPixelPenguinsWA.ServiceReference1.UsuarioWS)(this)).insertarUsuario(inValue);
            return retVal.@return;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<SoftPixelPenguinsWA.ServiceReference1.insertarUsuarioResponse> SoftPixelPenguinsWA.ServiceReference1.UsuarioWS.insertarUsuarioAsync(SoftPixelPenguinsWA.ServiceReference1.insertarUsuarioRequest request) {
            return base.Channel.insertarUsuarioAsync(request);
        }
        
        public System.Threading.Tasks.Task<SoftPixelPenguinsWA.ServiceReference1.insertarUsuarioResponse> insertarUsuarioAsync(SoftPixelPenguinsWA.ServiceReference1.usuario usuario) {
            SoftPixelPenguinsWA.ServiceReference1.insertarUsuarioRequest inValue = new SoftPixelPenguinsWA.ServiceReference1.insertarUsuarioRequest();
            inValue.usuario = usuario;
            return ((SoftPixelPenguinsWA.ServiceReference1.UsuarioWS)(this)).insertarUsuarioAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        SoftPixelPenguinsWA.ServiceReference1.eliminarUsuarioResponse SoftPixelPenguinsWA.ServiceReference1.UsuarioWS.eliminarUsuario(SoftPixelPenguinsWA.ServiceReference1.eliminarUsuarioRequest request) {
            return base.Channel.eliminarUsuario(request);
        }
        
        public int eliminarUsuario(SoftPixelPenguinsWA.ServiceReference1.usuario usuario) {
            SoftPixelPenguinsWA.ServiceReference1.eliminarUsuarioRequest inValue = new SoftPixelPenguinsWA.ServiceReference1.eliminarUsuarioRequest();
            inValue.usuario = usuario;
            SoftPixelPenguinsWA.ServiceReference1.eliminarUsuarioResponse retVal = ((SoftPixelPenguinsWA.ServiceReference1.UsuarioWS)(this)).eliminarUsuario(inValue);
            return retVal.@return;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<SoftPixelPenguinsWA.ServiceReference1.eliminarUsuarioResponse> SoftPixelPenguinsWA.ServiceReference1.UsuarioWS.eliminarUsuarioAsync(SoftPixelPenguinsWA.ServiceReference1.eliminarUsuarioRequest request) {
            return base.Channel.eliminarUsuarioAsync(request);
        }
        
        public System.Threading.Tasks.Task<SoftPixelPenguinsWA.ServiceReference1.eliminarUsuarioResponse> eliminarUsuarioAsync(SoftPixelPenguinsWA.ServiceReference1.usuario usuario) {
            SoftPixelPenguinsWA.ServiceReference1.eliminarUsuarioRequest inValue = new SoftPixelPenguinsWA.ServiceReference1.eliminarUsuarioRequest();
            inValue.usuario = usuario;
            return ((SoftPixelPenguinsWA.ServiceReference1.UsuarioWS)(this)).eliminarUsuarioAsync(inValue);
        }
    }
}
