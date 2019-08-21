package com.mingyaracosta.game.rules;

public abstract class IRuleImpl implements IRule {
    private IRule nextRule;

    public void setNextRule(IRule nextRule) {
        this.nextRule = nextRule;
    }

    @Override
    public IRule nextRule() {
        return nextRule;
    }
}
