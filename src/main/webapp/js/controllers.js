angular.module('moveit.controllers', [])

.controller('AddController', function($scope, $resource, $location, Quotation) {
    $scope.quotation = new Quotation();

    $scope.addQuotation = function() {
        $scope.quotation.$save(function(quotation) {
            console.log(quotation.quotationId);
            $location.path('/view/' + quotation.quotationId);
        });
    }
})

.controller('ViewController', function($scope, $routeParams, Quotation) {
    $scope.quotation = Quotation.get({ id: $routeParams.id });
});
