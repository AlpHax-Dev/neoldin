import os

def parse(code):
    """Parse the code into a nested list structure"""
    tokens = code.replace("(", " ( ").replace(")", " ) ").split()
    stack = [[]]
    for token in tokens:
        if token == "(":
            stack.append([])
        elif token == ")":
            if len(stack) > 1:
                current = stack.pop()
                stack[-1].append(current)
        else:
            try:
                stack[-1].append(int(token))
            except ValueError:
                stack[-1].append(token)
    return stack[0]

def eval_lisp(expr, env={}):
    if isinstance(expr, int):
        return expr
    elif isinstance(expr, str):
        return env.get(expr, globals().get(expr))
    elif isinstance(expr, list):
        if expr[0] == '+':
            return eval_lisp(expr[1], env) + eval_lisp(expr[2], env)
        elif expr[0] == '-':
            return eval_lisp(expr[1], env) - eval_lisp(expr[2], env)
        elif expr[0] == '*':
            return eval_lisp(expr[1], env) * eval_lisp(expr[2], env)
        elif expr[0] == '/':
            return eval_lisp(expr[1], env) / eval_lisp(expr[2], env)
        elif expr[0] == 'list':
            return [eval_lisp(e, env) for e in expr[1:]]
        elif expr[0] == 'define':
            env[expr[1]] = eval_lisp(expr[2], env)
        elif expr[0] == 'lambda':
            return lambda *args: eval_lisp(expr[2], dict(zip(expr[1], args)))
        elif expr[0] == 'print':
            print(eval_lisp(expr[1], env))
        else:
            return eval_lisp(expr[0], env)(*[eval_lisp(e, env) for e in expr[1:]])

def run_file(file_path):
    """Read the file and run the code"""
    if not file_path.endswith(".nlisp"):
        raise ValueError("Invalid file format, expected .nlisp")
    if not os.path.exists(file_path):
        raise ValueError("File not found")
    with open(file_path, "r") as file:
        code = file.read()
    parsed_code = parse(code)
    for expr in parsed_code:
        eval_lisp(expr)
