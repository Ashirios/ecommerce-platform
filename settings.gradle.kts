rootProject.name = "ecommerce-platform"

include("api-gateway")
include("user-service")
include("shared")

project(":api-gateway").projectDir = file("api-gateway")
project(":user-service").projectDir = file("services/user-service")
project(":shared").projectDir = file("shared")
