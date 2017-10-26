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
                    })
                    .state('organizadorDetail',{
                        url: '/{organizadorId:int}/detail',
                        parent: 'organizadores',
                        param: {
                            organizadorId: null
                        },
                        views: {
                            
                            'detailView': {
                                templateUrl: basePath + 'organizadores.detail.html',
                                controller: 'organizadorCtrl',
                                controllerAs: 'ctrl'
                            }
                        }       
                    })
                    .state('organizadoresCreate',{
                        url: '/create',
                        parent: 'organizadores',
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/new/organizadores.new.html',
                                controller: 'organizadorNewCtrl'
                            }
                        }        
                    })
                    .state('organizadorDelete',{
                       url: '/delete/{organizadorId:int}',
                        parent: 'organizadores',
                        param: {
                            organizadorId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/delete/organizadores.delete.html',
                                controller: 'organizadorDeleteCtrl'
                            }
                        }         
                    });
        }]);
})(window.angular);

