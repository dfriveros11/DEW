
(
        function (ng) {
            var mod = ng.module("usuarioModule");
            mod.constant("usuariosContext", "api/usuarios");
            mod.controller('usuarioUpdateCtrl', ['$scope', '$http', 'usuariosContext', '$state', '$rootScope',
                function ($scope, $http, usuariosContext, $state, $rootScope) {
                    $rootScope.edit = true;

                    var idUsuario = $state.params.usuarioId;
   
                    $http.get(usuariosContext + '/' + idUsuario).then(function (response) {
                        var usuario = response.data;
                        $scope.usuario.nombreUsuario= usuario.nombreUsuario;
                        $scope.usuario.email=usuario.email;
                        $scope.usuario.ciudad=usuario.ciudad;
                        $scope.usuario.pais=usuario.pais;
                        $scope.usuario.password=usuario.password;
                        $scope.usuario.userName=usuario.username;
                    });
                $scope.updateUsuario= function () {
                    $http.put(usuariosContext + "/" + idUsuario, $scope.usuario).then(function (response) {
                    $state.go('usuarioList', {usuarioId: response.data.id}, {reload: true});
                });
                };
                }
            ]);
        }
)(angular);

