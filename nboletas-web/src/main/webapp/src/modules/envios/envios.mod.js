/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = angular.module("enviosModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/envios/';
            $urlRouterProvider.otherwise("/envios");
            $stateProvider
                    .state('envios', {
                        url: "/envios",
                        views: {
                            'mainView':{
                                templateUrl: basePath + 'envios.html'
                            }
                        }
                        
                    })
                    .state('enviosList', {
                        url: '/list',
                        parent: 'envios',
                        views:{
                            'listView':{
                                templateUrl: basePath + 'envios.list.html',
                                controller: 'envioCtrl',
                                controllerAs: 'ctrl'
                            }
                        }
                    })
                    .state('envioDetail',{
                        url: '/{envioId:int}/detail',
                        parent: 'envios',
                        param: {
                            envioId: null
                        },
                        views: {                         
                            'detailView': {
                                templateUrl: basePath + 'envios.detail.html',
                                controller: 'envioCtrl',
                                controllerAs: 'ctrl'
                            }
                        }       
                    })
                    .state('enviosCreate',{
                        url: '/create',
                        parent: 'envios',
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/new/envios.new.html',
                                controller: 'enviosNewCtrl'
                            }
                        }        
                    })
                    .state('envioUpdate', {
                        url: '/update/{envioId:int}',
                        parent: 'envios',
                        param: {
                            envioId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/update/envios.update.html',
                                controller: 'envioUpdateCtrl'
                            }
                        }
                    })
                    .state('envioDelete',{
                       url: '/delete/{envioId:int}',
                        parent: 'envios',
                        param: {
                            envioId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/delete/envios.delete.html',
                                controller: 'envioDeleteCtrl'
                            }
                        }         
                    });
        }]);
})(window.angular);

