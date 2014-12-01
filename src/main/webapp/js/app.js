angular.module('moveit', [
    'ngRoute',
    'moveit.controllers',
    'moveit.services'
])

.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/add', {
        templateUrl: 'partials/add.html',
        controller: 'AddController'
    });
    $routeProvider.when('/view/:id', {
        templateUrl: 'partials/view.html',
        controller: 'ViewController'
    });
    $routeProvider.otherwise({redirectTo: '/add'});
}]);
