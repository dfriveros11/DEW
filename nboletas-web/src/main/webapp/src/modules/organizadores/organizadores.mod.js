/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = angular.module("organizadoresModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/organizadores/';
            $urlRouterProvider.otherwise("/organizadoresList");
            $stateProvider
                    .state('organizadoresList', {
                        url: '/organizadores/list',
                        views:{
                            'listView':{
                                templateUrl: basePath + 'organizadores.list.html',
                                controller: 'organizadorCtrl',
                                controllerAs: 'ctrl'
                            }
                        }
                    })
                    .state('organizadorDetail',{
                        url: '/organizadores/{organizadorId:int}/detail',
                        param: {
                            organizadorId: null
                        },
                        views: {
                            'listView': {
                                templateUrl: basePath + 'listEspectaculos/espectaculos.list.html',
                                controller: 'organizadorCtrl',
                                controllerAs: 'ctrl'
                            },
                            'detailView': {
                                templateUrl: basePath + 'organizadores.detail.html',
                                controller: 'organizadorCtrl',
                                controllerAs: 'ctrl'
                            }
                        }       
                    })
                    .state('organizadoresCreate',{
                        url: '/organizadores/create',
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/new/organizadores.new.html',
                                controller: 'organizadorNewCtrl'
                            }
                        }        
                    })
                    .state('organizadorUpdate', {
                        url: '/organizadores/update/{organizadorId:int}',
                        param: {
                            organizadorId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/update/organizadores.update.html',
                                controller: 'organizadorUpdateCtrl'
                            }
                        }
                    })
                    .state('organizadorUpdateEspectaculo', {
                        url: '/organizadores/createEspectaculo/{organizadorId:int}',
                        param: {
                            organizadorId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/update/organizadores.updateEspectaculo.html',
                                controller: 'organizadorUpdateEspectaculoCtrl'
                            }
                        }
                    })
                    .state('organizadorDelete',{
                       url: '/organizadores/delete/{organizadorId:int}',
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

