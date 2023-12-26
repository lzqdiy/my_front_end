from importlib import import_module
from jsonschema import validate
from fastapi import FastAPI,Header,Body
import uvicorn


app = FastAPI()


@app.get("/api/get/{item_id}")
def read_item(item_id, q=3, token=Header(None)):
    return {"item_id": item_id, "q": q, "token": token}

@app.post("/api/post")
def exam(request=Body(None)):

    # 引数リストを取得
    for req in request:
        print(req)

    # キーより引数値を取得
    param1 = request["param1"]
    param2 = request["param2"]
    return {"param1": param1, "param2": param2}



@app.api_route("/api/all", methods=("GET", "POST"))
def all():
    return {"result": "OK", "content": "dfdfdfd"}
