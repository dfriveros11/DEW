/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("lugaresModule", []);
    mod.constant("lugaresContext", "api/lugares");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/lugares/';
            var basePathHtml = 'src/modules/';
            $urlRouterProvider.otherwise("/lugaresList");

            $stateProvider.state('lugaresList', {
                url: '/list',
                views: {
                    'listView': {
                        templateUrl: basePath + 'lugares.list.html',
                        controller: 'lugaresCtrl',
                        controllerAs: 'ctrl'
                    },
                    'miniPostView': {
                        templateUrl: basePathHtml + 'funciones/miniPosts.html',
                        controller: 'funcionesCtrl'
                    },
                    'postsListView': {
                        templateUrl: basePathHtml + 'artistas/postsList.html',
                        controller: 'artistaCtrl'
                    }
                }
            }).state('lugaresUpdate', {
                url: '/update/{lugarId:int}',
                param: {
                    lugarId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/update/lugares.update.html',
                        controller: 'lugaresUpdateCtrl'
                    }
                }
            }).state('lugaresCreate', {
                url: '/create',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/lugares.new.html',
                        controller: 'lugaresNewCtrl'
                    }
                }
            }).state('lugaresDelete', {
                url: '/delete/{lugarId:int}',

                param: {
                    funcionId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/lugares.delete.html',
                        controller: 'lugaresDeleteCtrl'
                    }
                }
            }).state('lugaresDetail', {
                url: '/{lugarId:int}/detail',

                param: {
                    funcionId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'lugares.detail.html',
                        controller: 'lugaresCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);



