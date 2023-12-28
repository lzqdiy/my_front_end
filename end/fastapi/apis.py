from importlib import import_module
from jsonschema import validate
from fastapi import FastAPI, Header, Body
from fastapi.responses import JSONResponse
from starlette.middleware.cors import CORSMiddleware  # 追加
import uvicorn
import subprocess


app = FastAPI()

# CORSを回避するために追加（今回の肝）
app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=False,  # 追記により追加
    allow_methods=["*"],  # 追記により追加
    allow_headers=["*"],  # 追記により追加
)


@app.get("/")
def index():
    """this is a hompagw"""
    return "Hello fastapi"


@app.get("/api/get/{item_id}")
def read_item(item_id, q=3, token=Header(None)):
    return {"item_id": item_id, "q": q, "token": token}


@app.post("/api/post")
def exam(request=Body(None)):
    # 引数リストを取得
    for req in request:
        print(req)

    schema = {
        "type": "object",
        "properties": {
            "examId": {"type": "integer", "minimum": 0},
            "pythonPath": {"type": "string"},
            "param1": {"type": "string"},
            "param2": {"type": "string"},
        },
        "required": ["examId", "pythonPath"],
    }

    # データのバリデーション
    res = validate(request, schema)

    # キーより引数値を取得
    examId = request["examId"]
    pythonPath = request["pythonPath"]
    param1 = request["param1"]
    param2 = request["param2"]

    # return JSONResponse(content={"request":request},status_code=200,headers={"a":"b"})
    # 別のPythonファイルを実行
    res = subprocess.run(["python", pythonPath, param1, param2], capture_output=True)
    # 標準出力、標準エラーを取得
    print("return code: {}".format(res.returncode))
    print("captured stdout: {}".format(res.stdout.decode()))
    print("captured stderr: {}".format(res.stderr.decode()))

    module1 = import_module("file.caseconf")
    module1.selectCase.execute(examId)
    return {"caseId": examId, "result": res.stdout.decode()}


@app.api_route("/api/all", methods=("GET", "POST"))
def all():
    return {"result": "OK", "content": "dfdfdfd"}


if __name__ == "__main__":
    uvicorn.run(app)
