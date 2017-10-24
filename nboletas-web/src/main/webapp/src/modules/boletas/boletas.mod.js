/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = angular.module("boletasModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/boletas/';
            $urlRouterProvider.otherwise("/boletas");
            $stateProvider
                    .state('boletas', {
                        url: "/boletas",
                        views: {
                            'mainView':{
                                templateUrl: basePath + 'boletas.html'
                            }
                        }
                        
                    })
                    .state('boletasList', {
                        url: '/list',
                        parent: 'boletas',
                        views:{
                            'listView':{
                                templateUrl: basePath + 'boletas.list.html',
                                controller: 'boletaCtrl',
                                controllerAs: 'ctrl'
                            }
                        }
                    });
        }]);
})(window.angular);


