local redis = require "resty.redis"
local cjson = require "cjson"
local red = redis.new()
red.connect(red, '127.0.0.1', '6379')

red:auth('123456')

local args = ngx.req.get_uri_args()
local uri = ngx.var.request_uri

local ipTest = red:get('ipTest')

ngx.say(ipTest ) 

if ipTest == ngx.null then 
    ngx.say('ipTest=nil')
else 
    ngx.say('fdsfafdfsafasdfdasfdsf' )
    ngx.say(ipTest ) 
    ngx.say('fdsfafdfsafasdfdasfdsf22' )
end
ngx.say(args)
ngx.say(uri)
ngx.say('\n--------------ngx.null = ')
ngx.say(ngx.null)

local callid = nil
local channel = 0

if  string.find(uri, 'yuntongxun') then
        callid = args["callid"]
        channel = 0
elseif  string.find(uri, 'yunhu') then
        ngx.req.read_body()
        local body_data = ngx.req.get_body_data()
        local data = cjson.decode(body_data)
        callid = data['call_id']
        channel = 1
elseif string.find(uri, 'huawei') then
        callid = args["vSessionsId"]
        channel = 2
else 

end

if callid == nil then
        ngx.say(uri)
        ngx.say(cjson.encode(args))
        ngx.say('callid is empty')
        return ''
end


local key = callid .. '_channel' .. channel
local res = red:get(key)
if res == ngx.null then
    ngx.say("redis get  error")
    return ''
end

ngx.var.backend = res