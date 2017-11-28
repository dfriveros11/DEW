/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = angular.module("espectaculosModule", ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/espectaculos/';
            $urlRouterProvider.otherwise("/espectaculos");
            $stateProvider
                    .state('espectaculos', {
                        url: "/espectaculos",
                        abstract: true,
                        views: {
                            'mainView':{
                                templateUrl: basePath + 'espectaculos.html',
                                controller: 'espectaculoCtrl',
                                controllerAs: 'ctrl'
                            }
                        }
                        
                    })
                    .state('espectaculosList', {
                        url: '/list',
                        views:{
                            'listView':{
                                templateUrl: basePath + 'espectaculos.list.html',
                                controller: 'espectaculoCtrl'
                            }
                        }
                    })
                    .state('espectaculoDetail' ,{
                        url: '/{espectaculoId:int}/detail',
                        parent: 'espectaculos',
                        param: {
                            espectaculoId: null
                        },
                        
                        views: {
                            'detailView': {
                                templateUrl: basePath + 'espectaculos.detail.html',
                                controller: 'espectaculoCtrl',
                                controllerAs: 'ctrl'
                            }
                        }
                    })
                    .state('espectaculosCreate',{
                        url: '/create',
                        parent: 'espectaculos',
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/new/espectaculos.new.html',
                                controller: 'espectaculoNewCtrl'
                            }
                        }        
                    })
                    .state('espectaculoArtista',{
                        url: '/{espectaculoId:int}/createArtista',
                        parent: 'espectaculos',
                        param: {
                            espectaculoId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/new/newArtista/espectaculos.newArtista.html',
                                controller: 'espectaculoNewArtistaCtrl'
                            }
                        }        
                    })
                    .state('espectaculoOrganizador',{
                        url: '/{espectaculoId:int}/createOrganizador',
                        parent: 'espectaculos',
                        param: {
                            espectaculoId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/new/newOrganizador/espectaculos.newOrganizador.html',
                                controller: 'espectaculoNewOrganizadorCtrl'
                            }
                        }        
                    })
                    .state('espectaculoUpdate', {
                        url: '/update/{espectaculoId:int}',
                        parent: 'espectaculos',
                        param: {
                            espectaculoId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/update/espectaculos.update.html',
                                controller: 'espectaculoUpdateCtrl'
                            }
                        }
                    })
                    .state('espectaculosDelete',{
                       url: '/delete/{espectaculoId:int}',
                        parent: 'espectaculos',
                        param: {
                            espectaculoId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/delete/espectaculos.delete.html',
                                controller: 'espectaculoDeleteCtrl'
                            }
                        }         
                    });
        }]);
})(window.angular);


