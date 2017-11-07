/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = angular.module("comentariosModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/comentarios/';
            $urlRouterProvider.otherwise("/comentarios");
            $stateProvider
                    .state('comentarios', {
                        url: "/comentarios",
                        abstract: true,
                        views: {
                            'mainView':{
                                templateUrl: basePath + 'comentarios.html',
                                controller: 'comentarioCtrl',
                                controllerAs: 'ctrl'
                            }
                        }              
                    })
                    .state('comentariosList', {
                        url: '/list',
                        parent: 'comentarios',
                        views:{
                            'listView':{
                                templateUrl: basePath + 'comentarios.list.html',
                                controller: 'comentarioCtrl',
                                controllerAs: 'ctrl'
                            }
                        }
                    })
                    .state('comentarioDetail',{
                        url: '/{comentarioId:int}/detail',
                        parent: 'comentarios',
                        param: {
                            comentarioId: null
                        },
                        views: {                         
                            'detailView': {
                                templateUrl: basePath + 'comentarios.detail.html',
                                controller: 'comentarioCtrl',
                                controllerAs: 'ctrl'
                            }
                        }       
                    })
                    .state('comentariosCreate',{
                        url: '/create',
                        parent: 'comentarios',
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/new/comentarios.new.html',
                                controller: 'comentariosNewCtrl'
                            }
                        }        
                    })
                    .state('comentarioUpdate', {
                        url: '/update/{comentarioId:int}',
                        parent: 'comentarios',
                        param: {
                            comentarioId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/update/comentarios.update.html',
                                controller: 'comentarioUpdateCtrl'
                            }
                        }
                    })
                    .state('comentarioDelete',{
                       url: '/delete/{comentarioId:int}',
                        parent: 'comentarios',
                        param: {
                            comentarioId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/delete/comentarios.delete.html',
                                controller: 'comentarioDeleteCtrl'
                            }
                        }         
                    });
        }]);
})(window.angular);

