/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = angular.module("espectaculosModule", ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/espectaculos/';
            $urlRouterProvider.otherwise("/espectaculosList");
            $stateProvider
                    .state('espectaculosList', {
                        url: '/espectaculo/list',
                        views:{
                            'listView':{
                                templateUrl: basePath + 'espectaculos.list.html',
                                controller: 'espectaculoCtrl'
                            }
                        }
                    })
                    .state('espectaculoDetail' ,{
                        url: '/espectaculo/{espectaculoId:int}/detail',
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
                        url: '/espectaculo/create',
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/new/espectaculos.new.html',
                                controller: 'espectaculoNewCtrl'
                            }
                        }        
                    })
                    .state('espectaculoArtista',{
                        url: '/espectaculo/{espectaculoId:int}/createArtista',
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
                        url: '/espectaculo/{espectaculoId:int}/createOrganizador',
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
                        url: '/espectaculo/update/{espectaculoId:int}',
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
                       url: '/espectaculo/delete/{espectaculoId:int}',
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


