/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("espectaculosModule");
    mod.constant("espectaculosContext", "api/espectaculos");
    mod.controller('espectaculoNewArtistaCtrl', ['$scope', '$http', 'espectaculosContext', '$state', '$rootScope',
        function ($scope, $http, espectaculosContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createEspectaculoArtista = function () {
                $http.post(espectaculosContext + '/' + $state.params.espectaculoId+'/artistas', {
                    id: $scope.espectaculoArtistaId
                }).then(function (response) {
                    $state.go('espectaculosList', {espectaculoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);

