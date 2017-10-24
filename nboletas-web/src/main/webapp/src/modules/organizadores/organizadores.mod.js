/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = angular.module("organizadoresModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/organizadores/';
            $urlRouterProvider.otherwise("/boletas");
            $stateProvider
                    .state('organizadores', {
                        url: "/organizadores",
                        views: {
                            'mainView':{
                                templateUrl: basePath + 'organizadores.html'
                            }
                        }
                        
                    })
                    .state('organizadoresList', {
                        url: '/list',
                        parent: 'organizadores',
                        views:{
                            'listView':{
                                templateUrl: basePath + 'organizadores.list.html',
                                controller: 'organizadorCtrl',
                                controllerAs: 'ctrl'
                            }
                        }
                    });
        }]);
})(window.angular);

