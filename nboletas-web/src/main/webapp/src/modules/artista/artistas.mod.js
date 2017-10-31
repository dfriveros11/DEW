(function (ng) {
    // Definición del módulo
    var mod = ng.module("artistaModule", ['ui.router']);

    // Configuración de los estados del módulo
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            // En basePath se encuentran los templates y controladores de módulo
            var basePath = 'src/modules/artistas/';
            // Mostrar la lista de editoriales será el estado por defecto del módulo
            $urlRouterProvider.otherwise("/artistasList");
            // Definición del estado 'editorialsList' donde se listan los editoriales
            $stateProvider.state('artistasList', {
                // Url que aparecerá en el browser
                url: '/artistas/list',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'artistas.list.html',
                        controller: 'artistaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);
