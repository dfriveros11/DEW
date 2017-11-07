
(
        function (ng) {
            var mod = ng.module("artistasModule");
            mod.constant("artistasContext", "api/artistas");
            mod.controller('artistaUpdateCtrl', ['$scope', '$http', 'artistasContext', '$state', '$rootScope', '$filter',
                function ($scope, $http, artistasContext, $state, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idArtista = $state.params.artistaId;

   
                    $http.get(artistasContext + '/' + idArtista).then(function (response) {
                        var artista = response.data;
                        $scope.artista.nombre= artista.nombre;
                        $scope.artista.imagen = artista.imagen;
                    });
                $scope.updateArtista= function () {
                    $http.put(artistasContext + "/" + idArtista, $scope.artista).then(function (response) {
                    $state.go('artistasList', {artistaId: response.data.id}, {reload: true});
                });
                };
                }
            ]);
        }
)(angular);

