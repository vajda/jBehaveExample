Scenario: greet with pera

Given name is pera
When I access greeting path with name
Then response body should be Hello, pera!

Scenario: greet with paja

Given name is paja
When I access greeting path with name
Then response body should be Hello, paja!

Scenario: greet with multiple

Given name is <name>
When I access greeting path with name
Then reponse body should be <hello>, <name>!

Examples:
| name     | hello |
| pera     | Hello |
| mika     | Hello |
| zika     | hello |
| Vladimir | Hello |