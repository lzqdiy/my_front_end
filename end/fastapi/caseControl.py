
from importlib import import_module
from fastapi import Body, FastAPI


app = FastAPI()


@app.post("/exam/call")
def execute(request=Body(None)):
 
    #キーより引数値を取得
    scriptKey=request["scriptKey"]
    param1=request["param1"]
    param2=request["param2"]


    module1=import_module("case.{}".format(scriptKey))
    ret=module1.main(param1,param2)
    return  module1.selectCase.execute(param1,param2)
