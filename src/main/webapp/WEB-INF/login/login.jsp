<!DOCTYPE html>
<html lang="es">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Iniciar sesión | Java Web</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
    <!-- icheck bootstrap -->
    <link rel="stylesheet" href="plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/adminlte.min.css">       
    <!-- Toastr --> <link rel="stylesheet" href="plugins/toastr/toastr.min.css">

</head>

<body class="hold-transition login-page">
    <div class="login-box">
        <!-- /.login-logo -->
        <div class="card card-outline card-primary">
            <div class="card-header text-center">
                <a href="index2.html" class="h1"><b>Proyecto</b>Java Web</a>
            </div>
            <div class="card-body">
                <p class="login-box-msg">Iniciar sesión</p>

                <form id="formulario-login" method="post">
                    <div class="input-group mb-3">
                        <input type="email" id="email" name="email" class="form-control"
                               placeholder="Correo electrónico">
                        <div class="input-group-append">
                            <div class="input-group-text">
                                <span class="fas fa-envelope"></span>
                            </div>
                        </div>
                    </div>
                    <div class="input-group mb-3">
                        <input type="password" id="password" name="password" class="form-control"
                               placeholder="Contraseña">
                        <div class="input-group-append">
                            <div class="input-group-text">
                                <span class="fas fa-lock"></span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <button type="submit" class="btn btn-primary btn-block">Ingresar</button>
                        </div>
                    </div>
                </form>
                <p class="mb-0">
                    <a href="registro.html" class="text-center">Registrarme como usuario</a>
                </p>
            </div>
            <!-- /.card-body -->
        </div>
        <!-- /.card -->
    </div>
    <!-- /.login-box -->
    <!-- /.login-box -->

    <!-- jQuery -->
    <script src="plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap 4 -->
    <script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- AdminLTE App -->
    <script src="dist/js/adminlte.min.js"></script>
    <script src="plugins/toastr/toastr.min.js"></script>
    <!-- Axios --> <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

    <script> document.getElementById("formulario-login").addEventListener("submit", function (evento) {
            evento.preventDefault();
            login();
        });

        function login() {
            const ruta = "login";
            const formulario = document.getElementById("formulario-login");
            const data = new FormData(formulario);
            axios.post(ruta, data).then(function (respuesta) {
                toastr.success("Iniciaste sesión correctamente");
                setTimeout(function () {
                    window.location.replace("admin");
                }, 1000);
            }).catch(function (error) {
                if (error.response) {
                    const mensaje = error.response.data;
                    toastr.error(mensaje);
                } else {
                    toastr.error("Error al intentar iniciar sesión");
                }
            });
        }</script>

</body>

</html>