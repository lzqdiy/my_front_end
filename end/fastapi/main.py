
import json
import requests

data = {'requsetId': 'John', 'age': 30}
json_data = json.dumps(data)
response = requests.post('http://localhost:8000/api/post/', data=json_data,
                         headers={'Content-Type': 'application/json'})
print(response.json())
print(response.json()["q"])
