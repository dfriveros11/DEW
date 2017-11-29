/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = angular.module("sillasModule", ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/sillas/';
            var basePathHtml = 'src/modules/';
            $urlRouterProvider.otherwise("/sillas");
            $stateProvider
                    .state('sillas', {
                        url: "/sillas",
                        abstract: true,
                        views: {
                            'mainView':{
                                templateUrl: basePath + 'sillas.html',
                                controller: 'sillasCtrl',
                                controllerAs: 'ctrl'
                            },
                            'miniPostView':{
                                templateUrl: basePathHtml + 'funciones/miniPosts.html',
                                controller: 'funcionesCtrl'
                            },
                            'postsListView':{
                                templateUrl: basePathHtml +'artistas/postsList.html',
                                controller: 'artistaCtrl'
                            }
                        }
                        
                    })
                    .state('sillasList', {
                        url: '/list',
                        parent: 'sillas',
                        views:{
                            'listView':{
                                templateUrl: basePath + 'sillas.list.html'
                            },
                            'miniPostView':{
                                templateUrl: basePathHtml + 'funciones/miniPosts.html',
                                controller: 'funcionesCtrl'
                            },
                            'postsListView':{
                                templateUrl: basePathHtml +'artistas/postsList.html',
                                controller: 'artistaCtrl'
                            }
                        }
                    })
                    .state('sillasDetail' ,{
                        url: '/{sillaId:int}/detail',
                        parent: 'sillas',
                        param: {
                            sillaId: null
                        },
                        
                        views: {
                            'detailView': {
                                templateUrl: basePath + 'sillas.detail.html',
                                controller: 'sillasCtrl',
                                controllerAs: 'ctrl'
                            },
                            'miniPostView':{
                                templateUrl: basePathHtml + 'funciones/miniPosts.html',
                                controller: 'funcionesCtrl'
                            },
                            'postsListView':{
                                templateUrl: basePathHtml +'artistas/postsList.html',
                                controller: 'artistaCtrl'
                            }
                        }
                    })
                    .state('sillasCreate',{
                        url: '/create',
                        parent: 'sillas',
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/new/sillas.new.html',
                                controller: 'sillasNewCtrl'
                            },
                            'miniPostView':{
                                templateUrl: basePathHtml + 'funciones/miniPosts.html',
                                controller: 'funcionesCtrl'
                            },
                            'postsListView':{
                                templateUrl: basePathHtml +'artistas/postsList.html',
                                controller: 'artistaCtrl'
                            }
                        }        
                    })
                    .state('sillasUpdate', {
                        url: '/update/{sillaId:int}',
                        parent: 'sillas',
                        param: {
                            sillaId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/update/sillas.update.html',
                                controller: 'sillasUpdateCtrl'
                            },
                            'miniPostView':{
                                templateUrl: basePathHtml + 'funciones/miniPosts.html',
                                controller: 'funcionesCtrl'
                            },
                            'postsListView':{
                                templateUrl: basePathHtml +'artistas/postsList.html',
                                controller: 'artistaCtrl'
                            }
                        }
                    })
                    .state('sillasDelete',{
                       url: '/delete/{sillaId:int}',
                        parent: 'sillas',
                        param: {
                            sillaId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/delete/sillas.delete.html',
                                controller: 'sillasDeleteCtrl'
                            },
                            'miniPostView':{
                                templateUrl: basePathHtml + 'funciones/miniPosts.html',
                                controller: 'funcionesCtrl'
                            },
                            'postsListView':{
                                templateUrl: basePathHtml +'artistas/postsList.html',
                                controller: 'artistaCtrl'
                            }
                        }         
                    });
        }]);
})(window.angular);


