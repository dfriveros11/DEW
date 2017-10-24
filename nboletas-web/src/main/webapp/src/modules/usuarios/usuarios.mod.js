{
function(ng){
    
    var mod = ng.module("usuariosModule", ['ui.router']);
        
    // Configuración de los estados del módulo
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
    // En basePath se encuentran los templates y controladores de módulo
    var basePath = 'src/modules/usuarios/';
            // Mostrar la lista de usuarios será el estado por defecto del módulo
            $urlRouterProvider.otherwise("/usuariosList");
            // Definición del estado 'usuariosList' donde se listan los usuarios
            $stateProvider.state('usuariosList', {
               // Url que aparecerá en el browser
                url: '/usuarios/list',
                        views: {
                        'mainView': {
                            templateUrl: basePath + 'usuarios.list.html',
                                   controller: 'usuariosCtrl',
                                   controllerAs: 'ctrl'
                            }
                        }
                }
            );
        }
    }
}(window.angular);

