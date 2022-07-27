import requests
import json

GITHUB_API="https://api.github.com"
API_TOKEN=''

#form a request URL
url="https://api.github.com/gists/675e509c79fefc2ff48ed6d158834264"
print ("Request URL: %s"%url)

#print headers,parameters,payload
headers={'Authorization':'token %s'%API_TOKEN}
params={'scope':'gist'}
payload={"files":{"test":{"content":"Le Contenu"}}}
#payload={"description":"GIST created by python code"}
#make a requests
res=requests.patch(url,headers=headers,params=params,data=json.dumps(payload))

print(str(res))


import os
