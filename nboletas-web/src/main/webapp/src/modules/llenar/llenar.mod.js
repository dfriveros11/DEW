/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = angular.module("rellenarModule", ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
           var basePath = 'src/modules/';
           $urlRouterProvider.otherwise("/rellenar");
            $stateProvider
                    .state('rellenar', {
                        url: "",
                        views: {
                            'listView':{
                                templateUrl: basePath + 'html/main.html'
                            },
                            'miniPostView':{
                                templateUrl: basePath + 'html/miniPosts.html'
                            },
                            'postsListView':{
                                templateUrl: basePath +'html/postsList.html'
                            }
                        }
                    });
        }]);
})(window.angular);


